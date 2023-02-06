package com.springbootstarterch0308springmvcssl.demo.library.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootstarterch0308springmvcssl.demo.library.Book;
import com.springbootstarterch0308springmvcssl.demo.library.service.BookService;

@Configuration
public class InitializerConfig {

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}
}
