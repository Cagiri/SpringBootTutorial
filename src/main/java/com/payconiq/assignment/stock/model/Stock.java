package com.payconiq.assignment.stock.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Stock {

	private UUID id;
	@NotNull(message = "Price should be filled.") 
	private BigDecimal currentPrice;
	@PositiveOrZero(message = "Could should be more than zero.")
	private int stockCount;
	private long lastUpdated;
	
	public Stock() {
		//do nothing..
	}
	
	public Stock(UUID id,BigDecimal currentPrice,int stockCount,long lastUpdated) {
		this.id = id;
		this.currentPrice = currentPrice;
		this.stockCount = stockCount;
		this.lastUpdated = lastUpdated;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
		return String.format("Stock Info [ Stock Id = %s - Current Price = %s", id,currentPrice);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Stock))
			return false;
		
		Stock other = (Stock) obj;
		return (id != null && other.id != null) && id.equals(other.id);
	}
}
