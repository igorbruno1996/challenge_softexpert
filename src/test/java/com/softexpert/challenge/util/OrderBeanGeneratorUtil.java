package com.softexpert.challenge.util;

import com.softexpert.challenge.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

public class OrderBeanGeneratorUtil {

    public static OrderBean getOrderBean() {

        return OrderBean.builder().
                amounts(List.of(10.0)).
                deliveryAmount(8.0).
                discountAmount(5.0).
                totalOrder(2).
                paymentMethodId(1L).
                payeeId("mistersonya").
                build();
    }
}
