package com.payconiq.assignment.stock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.stock.service.StockService;

@RestController
@RequestMapping(path="/api")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping(path="/stocks/")
	@ResponseBody
	public ModelAndView getStocks() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stock-list");
		return mav.addObject("stockList", stockService.getStocks());
	}
	
	@GetMapping(path="/stocks/{ID}")
	@ResponseBody
	public ModelAndView getStock (@PathVariable("ID") String id) {
		ModelAndView mav = new ModelAndView();
		return mav.addObject("stockInfo", stockService.getStock(id));
	}
	
	@PutMapping(path="/stocks/{ID}")
	public ModelAndView updateStock(@PathVariable(name="ID") String id,@RequestBody Stock stock) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("create-stock");
		return mav.addObject("updatedStockInfo", stockService.updateStock(id, stock.getCurrentPrice(), stock.getStockCount()));
	}
	
	@PostMapping(path="/stocks/")
	public ResponseEntity<Stock> addStock (@Valid @RequestBody Stock stock) {
		Stock addedStock = stockService.addStock(stock);
		
		if (addedStock != null) {
			return ResponseEntity.ok(addedStock);	
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
}
