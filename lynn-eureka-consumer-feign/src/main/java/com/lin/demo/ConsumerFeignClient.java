package com.lin.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * User: LinZhaoguan
 * Date: 2018/3/30
 * Time: 17:19
 * Description:
 */
@FeignClient("lynn-eureka-client")
public interface ConsumerFeignClient {

    @GetMapping("/dc")
    String consumer();
}
