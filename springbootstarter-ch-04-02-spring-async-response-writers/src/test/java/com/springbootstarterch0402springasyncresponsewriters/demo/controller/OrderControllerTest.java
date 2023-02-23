package com.springbootstarterch0402springasyncresponsewriters.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.springbootstarterch0402springasyncresponsewriters.demo.data.Order;
import com.springbootstarterch0402springasyncresponsewriters.demo.service.OrderService;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void responseBodyEmitterTest() throws Exception {
		when(orderService.findAll())
		.thenReturn(List.of(new Order("1234", BigDecimal.TEN)));
		
		MvcResult mvcResult = mockMvc.perform(get("/orders/rb"))
		.andExpect(request().asyncStarted())
		.andDo(MockMvcResultHandlers.log())
		.andReturn();
		
		mockMvc.perform(asyncDispatch(mvcResult))
		.andDo(MockMvcResultHandlers.log())
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":\"1234\",\"amount\":10}"));
	}
	
	@Disabled
	@Test
	public void sseEmitterTest() throws Exception {
		when(orderService.findAll())
		.thenReturn(List.of(new Order("1234", BigDecimal.TEN)));
		
		MvcResult mvcResult = mockMvc.perform(get("/orders/sse"))
		.andExpect(request().asyncStarted())
		.andDo(MockMvcResultHandlers.log())
		.andReturn();
		
		mockMvc.perform(asyncDispatch(mvcResult))
		.andDo(MockMvcResultHandlers.log())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].data.id").value("1234"))
		.andExpect(jsonPath("$[*].data.amount").value(BigDecimal.TEN));
	}
}