package com.cloud.user.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.cloud.user.service.fegin.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author candy_seven
 * @date 2023/2/6 18:38
 */
@RestController
@RefreshScope//配置动态刷新
@RequestMapping("test")
@Slf4j
public class TestController {

    @Resource
    private OrderFeignService orderFeignService;

    @Value("${demo-test.user:1}")
    private String user;

    @Value("${demo-test.pwd:2}")
    private String pwd;

    @Value("${demo-test.name:2}")
    private String name;

    @SaIgnore
    @GetMapping("test")
    public String test() {
        log.info(user + ":" + pwd + ":" + name);
        return "ok";
    }

    @GetMapping(value = "order")
    public String order(@RequestParam("id") String orderId) {
        String orderRes = orderFeignService.getOrderInfo(orderId);
        return test() + "...." +orderRes;
    }
}
