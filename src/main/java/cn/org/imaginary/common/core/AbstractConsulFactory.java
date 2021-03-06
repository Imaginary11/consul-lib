package cn.org.imaginary.common.core;

import cn.org.imaginary.common.model.ConsulConfig;
import cn.org.imaginary.common.util.StringUtils;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.model.health.ServiceHealth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public abstract class AbstractConsulFactory implements ConsulFactory {
    protected ConsulConfig consulConfig = null;
    private final Logger logger = LoggerFactory.getLogger(AbstractConsulFactory.class);

    public AbstractConsulFactory(ConsulConfig consulConfig) {
        this.consulConfig = consulConfig;
    }

    @Override
    public boolean register() {
        try {
            logger.info("consul config == " + consulConfig);
            if (consulConfig == null || StringUtils.isEmpty(consulConfig.getDiscovery())
                    || !consulConfig.isEnabled()) {
                logger.error("service registration had been cancel duo to consul config  ");
                return false;
            }
            Registration.RegCheck check = getHealthCheck();
            if (check == null) {
                logger.error("service registration had been cancel duo to check config");
                return false;
            }
            Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromParts(consulConfig.getHost(), consulConfig.getPort())).build();
            AgentClient agent = consul.agentClient();
            ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
            builder.id(consulConfig.getDiscovery().getServiceId())
                    .name(consulConfig.getDiscovery().getServiceName())
                    .addTags(consulConfig.getDiscovery().getTags())
                    .address(consulConfig.getDiscovery().getServiceHost())
                    .port(consulConfig.getDiscovery().getServicePort())
                    .addChecks(check);
            agent.register(builder.build());
            logger.info("register service " + consulConfig.getDiscovery().getServiceName() + " success");
        } catch (Exception e) {
            logger.error("register service error", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deregister(String serviceId) {
        try {
            if (consulConfig == null || !consulConfig.isEnabled()) {
                logger.error("service deregistration had been cancel duo to config");
                return false;
            }
            Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromParts(consulConfig.getHost(), consulConfig.getPort())).build();
            AgentClient agent = consul.agentClient();
            agent.deregister(serviceId);
            logger.info("deregister service " + serviceId + " success");
        } catch (Exception e) {
            logger.error("deregister service error", e);
            return false;
        }
        return true;
    }

    @Override
    public List<ServiceHealth> getService(String serviceName) {
        Registration.RegCheck check = getHealthCheck();
        if (consulConfig == null || check == null) {
            logger.error("get service had been cancel duo to config");
            return null;
        }
        Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromParts(consulConfig.getHost(), consulConfig.getPort())).build();
        HealthClient client = consul.healthClient();
        List<ServiceHealth> serviceHealths = client.getAllServiceInstances(serviceName).getResponse();
        serviceHealths.forEach((resp) -> {
            System.out.println(resp);
        });
        return serviceHealths;
    }

    protected abstract Registration.RegCheck getHealthCheck();

}
