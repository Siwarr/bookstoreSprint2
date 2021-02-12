package tn.esprit.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Panier;
import tn.esprit.demo.entities.User;
import tn.esprit.demo.service.IPanierService;


@RestController
public class PanierController {
	
	@Autowired
	IPanierService panierService;
	
	// http://localhost:8081/timesheet/servlet/retrieve-all-panier
	@GetMapping("/retrieve-all-panier")
	@ResponseBody
	public List<Panier> getAllPanier() {
		List<Panier> list = panierService.retrieveAllPanier();
		return list;
	}
	
	// http://localhost:8081/timesheet/servlet/add-panier/1/1/15-09-2015T11:20:02
	// http://localhost:8081/timesheet/servlet/add-panier/1/1/11-02-2010T01:30:40
	@PostMapping("/add-panier/{user-id}/{book-id}/{date-p}")
	@ResponseBody
	public Panier addPanier(@PathVariable("book-id")String bookId,
			@PathVariable("user-id")String userId, 
			@PathVariable("date-p")String dateP) throws Exception {
		Panier panier = panierService.addPanier(bookId,userId,dateP);
		return panier;
	}
	
	// http://localhost:8081/timesheet/servlet/retrieve-panier/1/1/15-09-2015T11:20:02
	@GetMapping("/retrieve-panier/{user-id}/{book-id}/{date-p}")
	@ResponseBody
	public Panier getPanier(@PathVariable("book-id")String bookId,
			@PathVariable("user-id")String userId, 
			@PathVariable("date-p")String dateP) throws Exception {
		return panierService.retrievePanier(bookId,userId,dateP);
	}
	
	// http://localhost:8081/timesheet/servlet/modify-panier/1/1/15-09-2015T11:20:02/5
	@PutMapping("/modify-panier/{user-id}/{book-id}/{date-p}/{quantity-p}")
	@ResponseBody
	public Panier modifyPanier(@PathVariable("book-id")String bookId,
			@PathVariable("user-id")String userId, 
			@PathVariable("date-p")String dateP,
			@PathVariable("quantity-p")String quantity) throws Exception {
		Panier panier=panierService.updatePanier(bookId,userId,dateP,quantity);
		return panier;
	}
	
	// http://localhost:8081/timesheet/servlet/remove-panier/1/1/15-09-2015T11:20:02
	@DeleteMapping("/remove-panier/{user-id}/{book-id}/{date-p}")
	@ResponseBody
	public void removePanier(@PathVariable("book-id")String bookId,
			@PathVariable("user-id")String userId, 
			@PathVariable("date-p")String dateP) throws Exception {
		panierService.deletePanier(bookId,userId,dateP);
	}
	
	
	// http://localhost:8081/timesheet/servlet/retrieve-books-p/1
	@GetMapping("/retrieve-books-p/{user-id}")
	@ResponseBody
	public List<Book> getAllBookByUser(@PathVariable("user-id")String userId) {
		return panierService.findAllBookByUserJPQL(userId);
	}
	
	
	// http://localhost:8081/timesheet/servlet/retrieve-users-p/1
	@GetMapping("/retrieve-users-p/{book-id}")
	@ResponseBody
	public List<User> getAllUserByBook(@PathVariable("book-id")String bookId) {
		return panierService.findAllUserByBookJPQL(bookId);
	}
	
	
	// http://localhost:8081/timesheet/servlet/retrieve-panier/1
	@GetMapping("/retrieve-panier/{user-id}")
	@ResponseBody
	public List<Panier> getAllNonConfirmedPanierByUser(@PathVariable("user-id")String userId) {
		return panierService.findAllNonConfirmedPanierByUserJPQL(userId);
	}
	
	
	// http://localhost:8081/timesheet/servlet/valider-panier/1
	@PutMapping("/valider-panier/{user-id}")
	@ResponseBody
	public void confirmerPanier(@PathVariable("user-id")String userId) {
		panierService.validerPanier(userId);
	}
	

}

