package com.softexpert.challenge.bean;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1381594287753397659L;
	
	private List<Double> amounts;
	private Double deliveryAmount;
	private Double discountAmount;
	private Integer totalOrder;
	private Long paymentMethodId;
	private String payeeId;
}
