package com.payconiq.assignment.stock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		mav.addObject("stock", new Stock());
		mav.setViewName("stock-list");
		return mav.addObject("stockList", stockService.getStocks());
	}
	
	@GetMapping(path="/stocks/1")
	@ResponseBody
	public ModelAndView getStock (@RequestParam("ID") String id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stock-get");
		return mav.addObject("stockInfo", stockService.getStock(id));
	}
	
	@PutMapping(path="/stocks/1")
	public ModelAndView updateStock(@ModelAttribute @Valid Stock stock) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav.addObject("updatedStockInfo", stockService.updateStock(stock.getId(), stock.getCurrentPrice(), stock.getStockCount()));
	}
	
	@PostMapping(path="/stocks/")
	public ModelAndView addStock (@Valid  @ModelAttribute Stock stock) {
		stockService.addStock(stock);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stock-list");
		mav.addObject("stockList", stockService.getStocks());
		return mav;
	}
}
