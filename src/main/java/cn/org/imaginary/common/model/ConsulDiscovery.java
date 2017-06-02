package cn.org.imaginary.common.model;

/**
 * discory config
 *
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class ConsulDiscovery {
    private String serviceId;
    private String serviceName;
    private String serviceHost;
    private int servicePort;
    private String healthCheckType;
    private String healthCheckUrl;
    private String healthCheckScript;
    private String healthCheckInterval;
    private String tags;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceHost() {
        return serviceHost;
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
    }

    public String getHealthCheckType() {
        return healthCheckType;
    }

    public void setHealthCheckType(String healthCheckType) {
        this.healthCheckType = healthCheckType;
    }

    public String getHealthCheckUrl() {
        return healthCheckUrl;
    }

    public void setHealthCheckUrl(String healthCheckUrl) {
        this.healthCheckUrl = healthCheckUrl;
    }

    public String getHealthCheckScript() {
        return healthCheckScript;
    }

    public void setHealthCheckScript(String healthCheckScript) {
        this.healthCheckScript = healthCheckScript;
    }

    public String getHealthCheckInterval() {
        return healthCheckInterval;
    }

    public void setHealthCheckInterval(String healthCheckInterval) {
        this.healthCheckInterval = healthCheckInterval;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
