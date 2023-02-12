package com.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author candy_seven
 * @date 2023/2/6 20:18
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @RequestMapping("getOrderInfo")
    public String getOrderInfo(@RequestParam("orderId") String orderId) {
        log.info("收到订单查询请求");
        return "当前订单号码：" + orderId;
    }
}
