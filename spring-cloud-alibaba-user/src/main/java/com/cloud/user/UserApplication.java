package com.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author candy_seven
 * @date 2023/2/5 20:54
 */
@SpringBootApplication
@EnableDiscoveryClient//服务注册发现
@EnableFeignClients//激活对Feign的使用 这个注解是添加在调用端，开启服务调用
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
