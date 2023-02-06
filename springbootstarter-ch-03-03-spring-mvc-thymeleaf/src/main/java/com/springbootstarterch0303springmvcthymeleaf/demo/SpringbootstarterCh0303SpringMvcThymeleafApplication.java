package com.springbootstarterch0303springmvcthymeleaf.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0303springmvcthymeleaf.demo.library.Book;
import com.springbootstarterch0303springmvcthymeleaf.demo.library.service.BookService;

@SpringBootApplication
public class SpringbootstarterCh0303SpringMvcThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0303SpringMvcThymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}
}
