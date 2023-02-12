package com.cloud.user.service.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author candy_seven
 * @date 2023/2/7 10:46
 */
@Component
@FeignClient(value = "cloud-demo-order")//需要寻找的微服务名称
public interface  OrderFeignService {

    @GetMapping(value = "/order/getOrderInfo")
    String getOrderInfo(@RequestParam("orderId") String orderId);
}
