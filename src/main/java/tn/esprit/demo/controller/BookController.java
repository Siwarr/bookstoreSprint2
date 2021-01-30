package tn.esprit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	private BookServiceImpl service;
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		return service.saveBook(b);
	}
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> Books){
		return service.saveBook(Books);
	}
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return service.getBooks();
	}
	@GetMapping("/book/{id}")
	public Book findBookById(@PathVariable("id") Long id) {
		return service.getBookById(id);
	}
	@GetMapping("/books/{nom}")
	public List<Book> findBookByNom(@RequestParam(value="nom") String nom) {
		return service.getBookByName(nom);
	}
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book b) {
		return service.updateBook(b);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		return service.deleteBook(id);
	}
}
