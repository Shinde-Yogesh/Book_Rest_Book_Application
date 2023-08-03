package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	/*
	 * private static List<Book> list = new ArrayList<>(); static { list.add(new
	 * Book(1, "Java Of Gems", "Gems Gosling")); list.add(new Book(2, "AI",
	 * "Elon Musk")); list.add(new Book(3, "Machine Learning", "Roburn Machnalt"));
	 * }
	 */

	@Autowired
	private BookRepository bookRepository;

	// Get all the Books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// Get By the Id
	public Book getById(int id) {
		return this.bookRepository.findById(id);
	}

	// Adding the Book
	public Book addBook(Book b) {
		Book result = this.bookRepository.save(b);
		return result;
	}

	// Deleting the book
	public void deletebook(int bid) {
		this.bookRepository.deleteById(bid);
	}
	/*
	 * list = list.stream().filter(book -> { if (book.getId() != bid) { return true;
	 * } else { return false; } }).collect(Collectors.toList()); }
	 */

	// Update the Book

	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
		/*
		 * list = list.stream().map(b -> { if (b.getId() == bookId) {
		 * b.setTitle(b.getTitle()); b.setAuthor(b.getAuthor()); }
		 * 
		 * return b; }).collect(Collectors.toList());
		 */
	}

}
