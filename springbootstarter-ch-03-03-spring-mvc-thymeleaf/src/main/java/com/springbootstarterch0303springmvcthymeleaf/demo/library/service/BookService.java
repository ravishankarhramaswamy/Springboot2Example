package com.springbootstarterch0303springmvcthymeleaf.demo.library.service;

import java.util.Optional;

import com.springbootstarterch0303springmvcthymeleaf.demo.library.Book;

public interface BookService {

	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
