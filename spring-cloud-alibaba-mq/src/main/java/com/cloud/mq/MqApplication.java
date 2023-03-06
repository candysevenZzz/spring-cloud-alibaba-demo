package com.cloud.mq;

import com.cloud.starter.mq.annotation.EnableCloudMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author candy_seven
 * @date 2023/3/3 15:37
 */
@SpringBootApplication
@EnableDiscoveryClient//服务注册发现
@EnableCloudMq//开启mq生产+消费
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }
}
