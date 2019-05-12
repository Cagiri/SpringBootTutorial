package com.payconiq.assignment.stock.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Stock {

	private String id;
	@NotNull(message = "Price should be filled.") 
	private BigDecimal currentPrice;
	@PositiveOrZero(message = "Could should be more than zero.")
	private int stockCount;
	@JsonIgnore
	private long lastUpdated;
	
	public Stock() {
		//do nothing..
	}
	
	public Stock(String id,BigDecimal currentPrice,int stockCount,long lastUpdated) {
		this.id = id;
		this.currentPrice = currentPrice;
		this.stockCount = stockCount;
		this.lastUpdated = lastUpdated;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return String.format("Stock Info [ Stock Id = %s - Current Price = %s - Stock count = %s ]", id,currentPrice,stockCount);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Stock))
			return false;
		
		Stock other = (Stock) obj;
		if ((id == null && other.id == null) && !id.equals(other.id)) {
			return false;
		}
		
		return (id == other.id && currentPrice.compareTo(other.currentPrice) == 0 && stockCount == other.stockCount);
	}
}
