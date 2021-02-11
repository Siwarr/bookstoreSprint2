package tn.esprit.demo;

import java.util.List;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.el.parser.ParseException;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.service.BookServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {
	
	@Autowired
	private BookServiceImpl bs;
	
	@Test
	public void testAjouterBook() {
		Book b= new Book("bondka","bondka","description",25f,true);
		bs.saveBook(b);
	}
	
	@Test
	public void testfindAllBooks() throws Exception {
		List<Book> l=bs.getBooks();
		l.forEach(c -> System.out.println(c.toString()));
	}
	@Test
	public void testRechercherBook() throws ParseException{
		Book b=bs.getBookById((long) 6);
		System.out.println(b.toString());
	}
	@Test
	public void testSupprimerBook() {
		bs.deleteBook((long) 6);
	}
	
	@Test
	public void testModifierBook() {
		Book b=new Book ("siwar","siwar","description",20f,true);
		bs.updateBook(b);
	}
	
}
