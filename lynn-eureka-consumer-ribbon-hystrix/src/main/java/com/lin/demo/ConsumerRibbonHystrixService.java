package com.lin.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: LinZhaoguan
 * Date: 2018/4/3
 * Time: 10:25
 * Description:
 */
@Service
public class ConsumerRibbonHystrixService {

    private final RestTemplate restTemplate;

    public ConsumerRibbonHystrixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://lynn-eureka-client/dc", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
