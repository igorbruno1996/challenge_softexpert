package com.softexpert.challenge.bean;

import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProcessedBean implements Serializable {

    private static final long serialVersionUID = 4150243546423296886L;

    private String paymentLink;
}
