package com.lin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: LinZhaoguan
 * Date: 2018/3/30
 * Time: 15:30
 * Description:
 */
@RestController
public class ConsumerRibbonController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerRibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://lynn-eureka-client/dc", String.class);
    }
}
