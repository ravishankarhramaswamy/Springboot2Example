package com.springbootstarterch0305springmvcinternationalization.demo.library.service;

import java.util.Optional;

import com.springbootstarterch0305springmvcinternationalization.demo.library.Book;

public interface BookService {

	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
