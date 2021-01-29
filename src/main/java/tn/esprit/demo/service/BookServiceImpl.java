package tn.esprit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookRepository repository;
	@Override
	public Book saveBook(Book b) {
		return repository.save(b);
	}
	@Override
	public List<Book> saveBook(List<Book> Books) {
		return repository.saveAll(Books);
	}
	@Override
	public List<Book> getBooks(){
		return repository.findAll();
		/*List<Books> books = new ArrayList<Books>();  
		booksRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;  
		}*/
	}
	@Override
	public Book getBookById(Long id){
		return repository.findById(id).get();
	}
	@Override
	public List<Book> getBookByName(String nom){
		return repository.findByNom(nom);
	}
	@Override
	public String deleteBook(Long id) {
		repository.deleteById(id);
		return "Book removed ||"+id;
	}
	@Override
	public Book updateBook(Book b) {
		Book existingBook=repository.findById(b.getId()).orElse(null);
		existingBook.setNom(b.getNom());
		existingBook.setAuteur(b.getAuteur());
		existingBook.setAvail(b.isAvail());
		existingBook.setDescription(b.getDescription());
		existingBook.setPrice(b.getPrice());
		return repository.save(existingBook);
	}
}
