package com.payconiq.assignment.test.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.payconiq.assignment.stock.model.Stock;
import com.payconiq.assignment.test.AbstractTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockControllerTest extends AbstractTest {

	private Stock stock;

	@Override
	@Before
	public void setUp() {
		stock = new Stock();
		stock.setCurrentPrice(BigDecimal.valueOf(2500));
		stock.setStockCount(250);
		super.setUp();
	}

	@Test
	public void getStocks() throws Exception {
		String uri = "/api/stocks/";
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(model().attributeExists("stockList"))
				.andExpect(model().attribute("stockList", hasSize(12)))
				.andReturn();
	}

	@Test
	public void getStockItem() throws Exception {
		String uri = "/api/stocks/1";
		mvc.perform(MockMvcRequestBuilders.get(uri).param("ID", "1").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(model().attributeExists("stockInfo"))
				.andExpect(model().attribute("stockInfo", hasProperty("id", is("1"))))
				.andExpect(model().attribute("stockInfo", hasProperty("currentPrice", is(BigDecimal.valueOf(6000)))))
				.andExpect(model().attribute("stockInfo", hasProperty("stockCount", is(2500))))
				.andReturn();
	}
	
	@Test
	public void updateStock() throws Exception {
		String uri = "/api/stocks/1";
		stock.setId("4");
		mvc.perform(MockMvcRequestBuilders.put(uri).flashAttr("stock", stock).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(model().attributeExists("updatedStockInfo"))
		.andExpect(model().attribute("updatedStockInfo", hasProperty("id", is(stock.getId()))))
		.andExpect(model().attribute("updatedStockInfo", hasProperty("currentPrice", is(stock.getCurrentPrice()))))
		.andExpect(model().attribute("updatedStockInfo", hasProperty("stockCount", is(stock.getStockCount()))))
		.andReturn();
		
	}
	
	@Test
	public void addStock() throws Exception {
		String uri = "/api/stocks/";
		mvc.perform(MockMvcRequestBuilders.post(uri).flashAttr("stock", stock).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(model().attributeExists("stockList"))
		.andExpect(model().attribute("stockList", hasSize(12)))
		.andReturn();
	}
}
