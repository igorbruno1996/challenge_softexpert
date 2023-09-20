package com.softexpert.challenge.service;

import com.softexpert.challenge.bean.OrderBean;
import com.softexpert.challenge.util.OrderBeanGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.cloud.config.enabled=false")
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void calculateOrderWithDiscountAndDelivery() {

        Double expected = this.orderService.calculateOrder(OrderBeanGeneratorUtil.getOrderBean());
        assertEquals(11.5, expected);
    }

    @Test
    void calculateOrderWithoutDiscountAndDelivery() {

        OrderBean orderBean = OrderBeanGeneratorUtil.getOrderBean();
        orderBean.getAdditionalTaxes().clear();
        orderBean.getDiscounts().clear();
        Double expected = this.orderService.calculateOrder(orderBean);
        assertEquals(10.0, expected);
    }
}
