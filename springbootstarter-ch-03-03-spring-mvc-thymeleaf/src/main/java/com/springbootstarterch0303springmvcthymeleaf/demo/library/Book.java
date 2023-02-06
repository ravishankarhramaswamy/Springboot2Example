package com.springbootstarterch0303springmvcthymeleaf.demo.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Book {

	private String isbn;
	private String title;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}
	
	public Book(String isbn, String title, String... authors) {
		this.isbn = isbn;
		this.title = title;
		this.authors.addAll(Arrays.asList(authors));
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", authors=" + authors + "]";
	}
	
}
