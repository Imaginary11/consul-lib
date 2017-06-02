package cn.org.imaginary.common;

import cn.org.imaginary.common.core.DefaultConsulFactory;
import cn.org.imaginary.common.core.ConsulFactory;
import cn.org.imaginary.common.model.ConsulConfig;
import cn.org.imaginary.common.model.ConsulDiscovery;
import org.junit.Test;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class ConsulTest {
    @Test
    public void testRegisterService() {
        ConsulFactory consulFactory = new DefaultConsulFactory();
        ConsulConfig consulConfig = new ConsulConfig();
        consulConfig.setHost("172.16.12.206");
        consulConfig.setPort(8500);
        consulConfig.setEnabled(true);
        ConsulDiscovery discovery = new ConsulDiscovery();
        discovery.setServiceHost("172.16.12.201");
        discovery.setServicePort(22);
        discovery.setHealthCheckType("tcp");
        discovery.setServiceId("consul-lib");
        discovery.setServiceName("consul-lib-service");
        discovery.setHealthCheckInterval("10s");
        consulConfig.setDiscovery(discovery);
        consulFactory.deregister(consulConfig,"consul-lib");
//        consulFactory.register();
//        consulFactory.getService("sae-service");
        consulFactory.deregister(consulConfig,"sae");
//

    }
}
