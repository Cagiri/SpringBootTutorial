package com.payconiq.assignment.stock.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payconiq.assignment.stock.model.Stock;

public interface StockService {
	
	public List<Stock> getStocks ();
	
	public Stock getStock (String stockId) ;
	
	public Stock updateStock(String id,BigDecimal newPrice,int stockCount);
	
	public Stock addStock (Stock stock);
}
