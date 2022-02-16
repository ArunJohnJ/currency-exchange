package com.microservice.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter  @NoArgsConstructor
public class CurrencyExchange {
	
	@Id
	private Long id;
	
	@Column(name = "currency_from")
	private String from; //since from is a keyword in a sql
	@Column(name = "currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	private String environment;
	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	
	
}
