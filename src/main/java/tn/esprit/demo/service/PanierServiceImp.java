package tn.esprit.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Panier;
import tn.esprit.demo.entities.PanierPK;
import tn.esprit.demo.entities.User;
import tn.esprit.demo.repository.BookRepository;
import tn.esprit.demo.repository.PanierRepository;
import tn.esprit.demo.repository.UserRepository;

@Service
public class PanierServiceImp implements IPanierService {
	
	private static final Logger l = LogManager.getLogger(PanierServiceImp.class);
	@Autowired
	PanierRepository panierRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Panier> retrieveAllPanier() {
		List<Panier> paniers =(List<Panier>) panierRepository.findAll();
		for(Panier panier:paniers) {
			l.info("panier +++: "+panier);
		}
		return paniers;
	}

	@Override
	public Panier addPanier(String bookId, String userId, String dateP) throws Exception {
		PanierPK panierPK = new PanierPK();
		panierPK.setDateP(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss").parse(dateP));
		panierPK.setIdUser(Integer.parseInt(userId));
		panierPK.setIdBook(Integer.parseInt(bookId));
		
		User user = userRepository.findById(Long.valueOf(userId)).get();
		Book book = bookRepository.findById(Long.valueOf(bookId)).get();
		
		Panier panier = new Panier();
		panier.setUser(user);
		panier.setBook(book);
		panier.setPanierPK(panierPK);
		panier.setQuantity(0); //par defaut 0
		panier.setIsValid(false); //par defaut false
		panier.setPrixT(0); //par defaut 0
		panierRepository.save(panier);
		l.info("panier added");
		return panier;
	}
	
	@Override
	public Panier retrievePanier(String bookId, String userId, String dateP) throws Exception {
		PanierPK panierPK = new PanierPK();
		panierPK.setDateP(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss").parse(dateP));
		panierPK.setIdUser(Integer.parseInt(userId));
		panierPK.setIdBook(Integer.parseInt(bookId));
		
		return panierRepository.findById(panierPK).get();
	}
	
	//modifier 'Quantity'+'prixTotale' avec controle
	@Transactional
		public Panier updatePanier(String bookId, String userId, String dateP, String quantityP) throws Exception {
			//User user = userRepository.findById(Long.valueOf(userId)).get();
			Book book = bookRepository.findById(Long.valueOf(bookId)).get();
			
			//verifier s'il y'a des ouvrages dans le stock
			if(book.getStock()==0){
				l.info("stock actuellement vide");
			}
			else if(book.getStock()<(Integer.parseInt(quantityP))){
				l.info("stock insuffisant");
			}
			else{
				PanierPK panierPK = new PanierPK();
				panierPK.setDateP(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss").parse(dateP));
				panierPK.setIdUser(Integer.parseInt(userId));
				panierPK.setIdBook(Integer.parseInt(bookId));
			Panier panier = panierRepository.findById(panierPK).get();
			panier.setQuantity(Integer.parseInt(quantityP));
			panier.setPrixT((Integer.parseInt(quantityP))*book.getPrix());
			l.info("panier modifier");
			panierRepository.save(panier);
			return panier;
			}
			return null;
		}
	
	@Override
	public void deletePanier(String bookId, String userId, String dateP) throws Exception {
		PanierPK panierPK = new PanierPK();
		panierPK.setDateP(new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss").parse(dateP));
		panierPK.setIdUser(Integer.parseInt(userId));
		panierPK.setIdBook(Integer.parseInt(bookId));
		
		panierRepository.deleteById(panierPK);
		l.info("panier supprimer");			
	}
	
	
	//retrieve JPQL 
	@Override
	public List<Book> findAllBookByUserJPQL(String userId){
		List<? extends Object> list = panierRepository.findAllBookByUser(Integer.parseInt(userId));
		return ((List<Book>) list);
	}
	
	
	@Override
	public List<User> findAllUserByBookJPQL(String bookId) {	
		List<? extends Object> list =panierRepository.findAllUserByBook(Integer.parseInt(bookId));
		return ((List<User>) list);
	}
	
	
	//affichage pour client (all panier non confirmed par user id)
	public List<Panier> findAllNonConfirmedPanierByUserJPQL(String userId){
		return panierRepository.findAllNonConfirmedPanierByUser(Integer.parseInt(userId));
	}
	
	
	//confimer commande (valider une panier)
	@Transactional
	public void validerPanier(String userId){
		List<Panier> nonConfirmed= panierRepository.findAllNonConfirmedPanierByUser(Integer.parseInt(userId));
		for(Panier p:nonConfirmed){
			Panier panier = panierRepository.findById(p.getPanierPK()).get();
			panier.setIsValid(true);
			panierRepository.save(panier);
		}
		l.info("panier confirmer");
	}

}
