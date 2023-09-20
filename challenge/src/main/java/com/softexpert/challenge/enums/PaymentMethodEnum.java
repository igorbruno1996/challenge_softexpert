package com.softexpert.challenge.enums;

import lombok.Getter;

@Getter
public enum PaymentMethodEnum {
	
	PICPAY(1L, "https://picpay.me/{accountId}/{amount}");
	
	private final Long id;
	private final String link;
	
	PaymentMethodEnum(Long id, String link) {
		
		this.id = id;
		this.link = link;
	}
	
	public static String getLinkById(Long id, String accountId, Double amount) {
		
        for (PaymentMethodEnum value : values()) {
            if (value.id.equals(id)) {

				String link = value.getLink();
				link = link.replace("{accountId}", accountId);
				link = link.replace("{amount}", String.valueOf(amount));
                return link;
            }
        }
        
        return null;
	}
}
