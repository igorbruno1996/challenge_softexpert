package com.softexpert.challenge.controller;

import com.softexpert.challenge.enums.PaymentMethodEnum;
import com.softexpert.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softexpert.challenge.bean.OrderBean;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String processOrder(@RequestBody OrderBean order) {

        Double netAmount = this.orderService.calculateOrder(order);
        return PaymentMethodEnum.getLinkById(order.getPaymentMethodId(), order.getPayeeId(), netAmount);
    }
}
