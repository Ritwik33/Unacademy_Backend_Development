package com.ritwik.microService1;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfigurations {

    /**
     * define a method that creates Bean containing the logic for sticky load balancing ...
     */

    @Bean
    public ServiceInstanceListSupplier stickyLoadBalancing(ConfigurableApplicationContext ctx) {
        return ServiceInstanceListSupplier.builder().
                withBlockingDiscoveryClient().
                withSameInstancePreference().build(ctx);
    }
}
