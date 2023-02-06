package com.springbootstarterch0302springmvcrestresources.demo.library.service;

import java.util.Optional;

import com.springbootstarterch0302springmvcrestresources.demo.library.Book;

public interface BookService {

	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
