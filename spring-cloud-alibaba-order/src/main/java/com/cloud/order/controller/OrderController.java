package com.cloud.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author candy_seven
 * @date 2023/2/6 20:18
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping("getOrderInfo")
    public String getOrderInfo(@RequestParam("orderId") String orderId) {
        return "当前订单号码：" + orderId;
    }
}
