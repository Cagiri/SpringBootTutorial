package com.payconiq.assignment.stock.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping(path="/api/stocks/")
	public List<Stock> getStocks () {
		return stockService.getStocks();
	}
	
	@GetMapping(path="/api/stocks/1")
	public Stock getStock (@RequestParam String uuid) {
		return stockService.getStock(UUID.fromString(uuid));
	}
	
	@PutMapping(path="/api/stocks/1")
	public Stock updateStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock.getId(), stock.getCurrentPrice(), stock.getStockCount());
	}
	
	@PostMapping(path="/api/stocks/")
	public ResponseEntity<Stock> addStock (Stock stock) {
		Stock addedStock = stockService.addStock(stock);
		
		if (addedStock != null) {
			return ResponseEntity.ok(addedStock);	
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
}
