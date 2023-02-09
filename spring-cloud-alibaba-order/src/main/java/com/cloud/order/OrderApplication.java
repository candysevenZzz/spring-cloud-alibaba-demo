package com.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author candy_seven
 * @date 2023/2/6 19:48
 */
@SpringBootApplication
@EnableDiscoveryClient//服务注册发现
@EnableFeignClients//这个注解是添加在调用端，开启服务调用
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
