package com.springbootstarterch0302springmvcrestresources.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0302springmvcrestresources.demo.library.Book;
import com.springbootstarterch0302springmvcrestresources.demo.library.service.BookService;

@SpringBootApplication
public class SpringbootstarterCh0302SpringMvcRestResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0302SpringMvcRestResourcesApplication.class, args);
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
