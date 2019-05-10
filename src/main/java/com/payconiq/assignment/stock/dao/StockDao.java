package com.payconiq.assignment.stock.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.util.StockUtil;

@Service
public class StockDao {

	private static List<Stock> stockList = new ArrayList<>();
	static {
		stockList.add(new Stock("1", BigDecimal.valueOf(6000),2500, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("2", BigDecimal.valueOf(900),1000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("3", BigDecimal.valueOf(250),8000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("4", BigDecimal.valueOf(520),0, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("5", BigDecimal.valueOf(630),3200, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("6", BigDecimal.valueOf(268),500, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("7", BigDecimal.valueOf(856),1, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("8", BigDecimal.valueOf(3200),900, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("9", BigDecimal.valueOf(1200),1000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("10", BigDecimal.valueOf(1700),50, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock("11", BigDecimal.valueOf(1250),20, StockUtil.createRandomTimestamp()));
	}
	

	public List<Stock> getStocks () {
		return stockList;
	}
	
	public Stock getStock (String stockId) {
		Optional<Stock> stock = stockList.stream().filter(s -> s.getId().equals(stockId)).findFirst();
		if (!stock.isPresent()) {
			throw new IllegalArgumentException("Stock should be defined.There is no such stock with given id : " + stockId.toString());
		}
		return stock.get();
	}
	
	public Stock updateStock(String id,BigDecimal newPrice,int stockCount) {
		Stock stock = getStock(id);
		int itemIndex = stockList.indexOf(stock);
		if (newPrice != null) {
			stock.setCurrentPrice(newPrice);	
		}
		if (stockCount > 0) {
			stock.setStockCount(stockCount);	
		}
		stock.setLastUpdated(new Date().getTime());
		
		stockList.set(itemIndex, stock);
		
		return stock;
	}
	
	public Stock addStock (Stock stock) {
		if (stock.getId() == null) {
			stock.setId(UUID.randomUUID().toString());
		}
		stock.setLastUpdated(new Date().getTime());
		
		stockList.add(stock);
		return stock;
	}
}
