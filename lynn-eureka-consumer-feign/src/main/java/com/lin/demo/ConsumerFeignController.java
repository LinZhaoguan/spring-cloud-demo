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
public class ConsumerFeignController {

    private final ConsumerFeignClient consumerFeignClient;

    @Autowired
    public ConsumerFeignController(ConsumerFeignClient consumerFeignClient) {
        this.consumerFeignClient = consumerFeignClient;
    }

    @GetMapping("/consumer")
    public String consumer() {
        return consumerFeignClient.consumer();
    }
}
