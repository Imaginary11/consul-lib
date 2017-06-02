package cn.org.imaginary.common.model;

/**
 * consul config
 *
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class ConsulConfig {
    private String host;
    private int port;
    private boolean enabled;
    private ConsulDiscovery discovery;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ConsulDiscovery getDiscovery() {
        return discovery;
    }

    public void setDiscovery(ConsulDiscovery discovery) {
        this.discovery = discovery;
    }
}
