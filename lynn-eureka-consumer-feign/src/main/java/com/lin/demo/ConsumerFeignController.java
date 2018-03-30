package com.lin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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

    @GetMapping("/testParam")
    Map<String, Object> testParam(@RequestParam("name") String name, @RequestParam("age") Integer age){
        return consumerFeignClient.testParam(name, age);
    }

    @PostMapping("/upload")
    public String upload(@RequestPart(value = "file") MultipartFile file) {
        return consumerFeignClient.upload(file);
    }
}
