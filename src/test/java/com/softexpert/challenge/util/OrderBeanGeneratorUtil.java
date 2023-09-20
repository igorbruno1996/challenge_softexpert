package com.softexpert.challenge.util;

import com.softexpert.challenge.bean.OrderBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderBeanGeneratorUtil {

    public static OrderBean getOrderBean() {

        return OrderBean.builder().
                amounts(Stream.of(10.0).collect(Collectors.toList())).
                deliveryAmount(8.0).
                discountAmount(5.0).
                totalOrder(2).
                paymentMethodId(1L).
                payeeId("mistersonya").
                build();
    }
}
