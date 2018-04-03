package com.lin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

//通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
@EnableConfigServer
//@EnableDiscoveryClient注解 将config-server注册到服务注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApplication {

//    http://localhost:2002/info
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
