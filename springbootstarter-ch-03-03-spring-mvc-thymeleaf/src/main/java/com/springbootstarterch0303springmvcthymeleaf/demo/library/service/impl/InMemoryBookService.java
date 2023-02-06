package com.springbootstarterch0303springmvcthymeleaf.demo.library.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.springbootstarterch0303springmvcthymeleaf.demo.library.Book;
import com.springbootstarterch0303springmvcthymeleaf.demo.library.service.BookService;

@Service
public class InMemoryBookService implements BookService{
	
	private final Map<String, Book> books = new ConcurrentHashMap<>();

	@Override
	public Iterable<Book> findAll() {
		return books.values();
	}

	@Override
	public Book create(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Optional<Book> find(String isbn) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(books.get(isbn));
	}

}
