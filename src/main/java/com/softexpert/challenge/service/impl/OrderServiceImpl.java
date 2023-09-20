package com.softexpert.challenge.service.impl;

import com.softexpert.challenge.bean.OrderBean;
import com.softexpert.challenge.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    public Double calculateOrder(OrderBean order) {

        Double liquidityAmount = order.getAmounts().stream().reduce(0.0, Double::sum);
        Double totalDiscount = order.getDiscounts().stream().reduce(0.0, Double::sum);
        Double totalTax = order.getAdditionalTaxes().stream().reduce(0.0, Double::sum);
        liquidityAmount = this.discount(liquidityAmount, totalDiscount, order.getTotalOrder());
        liquidityAmount = this.add(liquidityAmount, totalTax, order.getTotalOrder());
        return liquidityAmount;
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
