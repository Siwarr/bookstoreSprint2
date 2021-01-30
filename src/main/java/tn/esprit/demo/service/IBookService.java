package tn.esprit.demo.service;

import java.util.List;

import tn.esprit.demo.entities.Book;

public interface IBookService {

	public Book saveBook(Book b);
	public List<Book> saveBook(List<Book> Books);
	public List<Book> getBooks();
	public Book getBookById(Long id);
	public List<Book> getBookByName(String nom);
	public String deleteBook(Long id);
	public Book updateBook(Book b);
}
