package com.springbootstarterch0306springmvcresolvinguserlocales.demo.library.service;

import java.util.Optional;

import com.springbootstarterch0306springmvcresolvinguserlocales.demo.library.Book;

public interface BookService {

	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
