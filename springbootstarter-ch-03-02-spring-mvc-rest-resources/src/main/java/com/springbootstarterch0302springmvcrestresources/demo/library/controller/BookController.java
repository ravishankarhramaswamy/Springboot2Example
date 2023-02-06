package com.springbootstarterch0302springmvcrestresources.demo.library.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springbootstarterch0302springmvcrestresources.demo.library.Book;
import com.springbootstarterch0302springmvcrestresources.demo.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public Iterable<Book> list() {
		return bookService.findAll();
	}

	@GetMapping("/{isbn}")
	public ResponseEntity<Book> get(@PathVariable("isbn") String isbn) {
		return bookService.find(isbn).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book, UriComponentsBuilder uriBuilder) {
		Book created = bookService.create(book);
		URI newBookUri = uriBuilder.path("/books/{isbn}").build(created.getIsbn());
		return ResponseEntity.created(newBookUri).body(created);
	}
}
