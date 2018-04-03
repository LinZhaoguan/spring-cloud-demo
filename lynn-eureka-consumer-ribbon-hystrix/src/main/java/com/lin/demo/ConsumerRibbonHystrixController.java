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
public class ConsumerRibbonHystrixController {

    private final ConsumerRibbonHystrixService consumerRibbonHystrixService;

    @Autowired
    public ConsumerRibbonHystrixController(ConsumerRibbonHystrixService consumerRibbonHystrixService) {
        this.consumerRibbonHystrixService = consumerRibbonHystrixService;
    }


    @GetMapping("/consumer")
    public String consumer() {
        return consumerRibbonHystrixService.consumer();
    }
}
