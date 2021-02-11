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
import tn.esprit.demo.service.IBookService;

@RestController
public class BookController {

	@Autowired
	private IBookService service;
	//http://localhost:8090/addBook
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		return service.saveBook(b);
	}
	/*
	 *  "nom":"book8",
    "auteur":"auteur",
    "description":"desc",
    "price":22,
    "isAvail":1
	 */
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> Books){
		return service.saveBook(Books);
	}
	//http://localhost:8090/books
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return service.getBooks();
	}
	//http://localhost:8090/book/1
	@GetMapping("/book/{id}")
	public Book findBookById(@PathVariable("id") Long id) {
		return service.getBookById(id);
	}
	//http://localhost:8090/books?nom=ouvrage
	@GetMapping("/books/{nom}")
	public List<Book> findBookByNom(@RequestParam(value="nom") String nom) {
		return service.getBookByName(nom);
	}
	//http://localhost:8090/update
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book b) {
		return service.updateBook(b);
	}
	//http://localhost:8090/delete/3
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		return service.deleteBook(id);
	}
}
