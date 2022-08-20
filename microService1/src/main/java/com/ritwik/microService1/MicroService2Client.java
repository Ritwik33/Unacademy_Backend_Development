package com.ritwik.microService1;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * this class will be responsible for communicating to microService2
 */

//@FeignClient(value = "myFeignClient", url = "http://localhost:7072")
@FeignClient(value = "MICROSERVICE2")
@LoadBalancerClient(value = "MICROSERVICE2", configuration = LoadBalancerConfigurations.class)
public interface MicroService2Client {

    /**
     *
     * this method should have the logic to call the microService2
     *
     * No implementation needed, so use interface not a class ...
     *
     * @return
     */

    @GetMapping(value = "/ms2/v1/messages")
    public String getMessage();

}
