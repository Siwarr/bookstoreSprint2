package tn.esprit.demo.service;

import java.util.Date;
import java.util.List;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Panier;
import tn.esprit.demo.entities.User;



public interface IPanierService {
	
	List<Panier> retrieveAllPanier();
	
	Panier addPanier(String bookId, String userId, String dateP) throws Exception;
	Panier retrievePanier(String bookId, String userId, String dateP) throws Exception;
	Panier updatePanier(String bookId, String userId, String dateP, String quantityP) throws Exception;
	void deletePanier(String bookId, String userId, String dateP) throws Exception;
	List<Book> findAllBookByUserJPQL(String userId);
	List<User> findAllUserByBookJPQL(String bookId);
	List<Panier> findAllNonConfirmedPanierByUserJPQL(String userId);
	void validerPanier(String userId);

}
