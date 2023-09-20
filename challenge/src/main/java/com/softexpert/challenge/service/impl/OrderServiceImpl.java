package com.softexpert.challenge.service.impl;

import com.softexpert.challenge.bean.OrderBean;
import com.softexpert.challenge.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    public Double calculateOrder(OrderBean order) {

        Double netAmount = order.getAmounts().stream().reduce(0.0, Double::sum);
        netAmount = this.discount(netAmount, order.getDiscountAmount(), order.getTotalOrder());
        netAmount = this.add(netAmount, order.getDeliveryAmount(), order.getTotalOrder());
        return netAmount;
    }

    private Double discount(Double amount, Double discountAmount, Integer totalOrder) {

        if (discountAmount > 0) {

            return amount - (discountAmount / totalOrder);
        }

        return amount;
    }

    private Double add(Double amount, Double addAmount, Integer totalOrder) {

        if (addAmount > 0) {

            return amount + (addAmount / totalOrder);
        }

        return amount;
    }
}
