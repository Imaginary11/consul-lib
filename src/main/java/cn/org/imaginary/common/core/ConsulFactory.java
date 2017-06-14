package cn.org.imaginary.common.core;

import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public interface ConsulFactory {
    boolean register();

    boolean deregister(String serviceId);

    List<ServiceHealth> getService(String serviceName);
}
