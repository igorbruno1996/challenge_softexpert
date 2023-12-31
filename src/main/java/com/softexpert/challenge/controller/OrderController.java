package com.softexpert.challenge.controller;

import com.softexpert.challenge.bean.OrderProcessedBean;
import com.softexpert.challenge.enums.PaymentMethodEnum;
import com.softexpert.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.softexpert.challenge.bean.OrderBean;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderProcessedBean processOrder(@RequestBody OrderBean order) {

        Double netAmount = this.orderService.calculateOrder(order);
        return OrderProcessedBean.builder()
                .paymentLink(PaymentMethodEnum.getLinkById(order.getPaymentMethodId(), order.getPayeeId(), netAmount))
                .build();
    }
}
