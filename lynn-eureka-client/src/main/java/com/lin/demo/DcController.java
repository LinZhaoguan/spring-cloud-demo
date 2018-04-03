package com.lin.demo;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LinZhaoguan
 * Date: 2018/3/30
 * Time: 14:09
 * Description:
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//        Thread.sleep(10000);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/testParam")
    public Map<String, Object> testParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        System.out.println(name + age);
        return ImmutableMap.of("name", name, "age", age);
    }

    /**
     * consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(name = "file")MultipartFile file) {
        return file.getOriginalFilename();
    }

}
