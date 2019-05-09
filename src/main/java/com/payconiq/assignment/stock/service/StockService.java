package com.payconiq.assignment.stock.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payconiq.assignment.stock.dao.StockDao;
import com.payconiq.assignment.stock.model.Stock;

@Service
public class StockService {
	
	@Autowired
	private StockDao stockDao;

	public List<Stock> getStocks () {
		return stockDao.getStocks();
	}
	
	public Stock getStock (UUID stockId) {
		return stockDao.getStock(stockId);
	}
	
	public Stock updateStock(UUID id,BigDecimal newPrice,int stockCount) {
		return stockDao.updateStock(id, newPrice, stockCount);
	}
	
	public Stock addStock (Stock stock) {
		return stockDao.addStock(stock);
	}
}
