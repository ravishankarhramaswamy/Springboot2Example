package com.springbootstarterch0302springmvcrestresources.demo.library.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.springbootstarterch0302springmvcrestresources.demo.library.Book;
import com.springbootstarterch0302springmvcrestresources.demo.library.service.BookService;

@WebMvcTest
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	public void shoudReturnListOfBooks() throws Exception {
		when(bookService.findAll()).thenReturn(Arrays.asList(
				new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"),
				new Book("321", "Pro Spring MVC", "Marten Deinum", "Colin Yates")));
				
		mockMvc.perform(get("/books"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",hasSize(2)))
				.andExpect(jsonPath("$[*].isbn",containsInAnyOrder("123", "321")))
				.andExpect(jsonPath("$[*].title",
				containsInAnyOrder("Spring 5 Recipes", "Pro Spring MVC")));
	}
}
