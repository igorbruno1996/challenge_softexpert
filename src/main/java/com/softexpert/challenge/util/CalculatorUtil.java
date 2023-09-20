package com.softexpert.challenge.util;

import java.util.List;

public class CalculatorUtil {

    public static Double sumItems(List<Double> items) {

        return items.stream().reduce(0.0, Double::sum);
    }
}
