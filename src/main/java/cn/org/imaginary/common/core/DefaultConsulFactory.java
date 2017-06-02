package cn.org.imaginary.common.core;

import cn.org.imaginary.common.model.ConsulConfig;
import cn.org.imaginary.common.model.ConsulDiscovery;
import com.alibaba.fastjson.JSONObject;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.Registration;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class DefaultConsulFactory extends AbstractConsulFactory {

    @Override
    protected Registration.RegCheck getHealthCheck(ConsulConfig consulConfig) {

        ConsulDiscovery discovery = consulConfig.getDiscovery();

        String healthCheckType = discovery.getHealthCheckType();
        ImmutableRegCheck.Builder builder = null;
        switch (healthCheckType) {
            case "tcp":
                builder = ImmutableRegCheck.builder()
                        .tcp(discovery.getServiceHost() + ":" + discovery.getServicePort());
                break;
            case "http":
                builder = ImmutableRegCheck.builder()
                        .http(discovery.getHealthCheckUrl());
                break;
            case "script":
                builder = ImmutableRegCheck.builder().script(discovery.getHealthCheckScript());
                break;
            case "ping":
//                builder = ImmutableRegCheck.builder().ttl(String.format("%ss", 3l));
            default:
                return null;
        }
        ImmutableRegCheck check = builder.interval(discovery.getHealthCheckInterval())
                .build();
        return check;
    }
}
