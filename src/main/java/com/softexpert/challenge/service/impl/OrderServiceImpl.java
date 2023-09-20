package com.softexpert.challenge.service.impl;

import com.softexpert.challenge.bean.OrderBean;
import com.softexpert.challenge.service.OrderService;
import com.softexpert.challenge.util.CalculatorUtil;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    public Double calculateOrder(OrderBean order) {

        Double liquidityAmount = CalculatorUtil.sumItems(order.getAmounts());
        Double totalDiscount = CalculatorUtil.sumItems(order.getDiscounts());
        Double totalTax = CalculatorUtil.sumItems(order.getAdditionalTaxes());
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
