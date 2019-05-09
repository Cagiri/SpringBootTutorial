package com.payconiq.assignment.stock.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.util.StockUtil;

@Service
public class StockDao {

	private static List<Stock> stockList = new ArrayList<>();
	static {
		stockList.add(new Stock(UUID.randomUUID(), null,2500, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(900),1000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(250),8000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(520),0, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(630),3200, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(268),500, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(856),1, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(3200),900, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(1200),1000, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(1700),50, StockUtil.createRandomTimestamp()));
		stockList.add(new Stock(UUID.randomUUID(), BigDecimal.valueOf(1250),20, StockUtil.createRandomTimestamp()));
	}
	

	public List<Stock> getStocks () {
		return stockList;
	}
	
	public Stock getStock (UUID stockId) {
		Optional<Stock> stock = stockList.stream().filter(s -> s.getId().equals(stockId)).findFirst();
		if (!stock.isPresent()) {
			throw new IllegalArgumentException("Stock should be defined.There is no such stock with given id : " + stockId.toString());
		}
		return stock.get();
	}
	
	public Stock updateStock(UUID id,BigDecimal newPrice,int stockCount) {
		Stock stock = getStock(id);
		if (newPrice != null) {
			stock.setCurrentPrice(newPrice);	
		}
		if (stockCount > 0) {
			stock.setStockCount(stockCount);	
		}
		
		//TODO : update stock list..
		
		return stock;
	}
	
	public Stock addStock (Stock stock) {
		if (stock.getId() == null) {
			stock.setId(UUID.randomUUID());
		}
		stockList.add(stock);
		return stock;
	}
}
