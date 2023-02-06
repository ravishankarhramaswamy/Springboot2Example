package com.springbootstarterch0304springmvchandlingexception.demo.library.service;

import java.util.Optional;

import com.springbootstarterch0304springmvchandlingexception.demo.library.Book;

public interface BookService {

	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
