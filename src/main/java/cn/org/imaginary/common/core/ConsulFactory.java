package cn.org.imaginary.common.core;

import cn.org.imaginary.common.model.ConsulConfig;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public interface ConsulFactory {
    boolean register(ConsulConfig consulConfig);

    boolean deregister(ConsulConfig consulConfig, String serviceId);

    List<ServiceHealth> getService(ConsulConfig consulConfig, String serviceName);
}
