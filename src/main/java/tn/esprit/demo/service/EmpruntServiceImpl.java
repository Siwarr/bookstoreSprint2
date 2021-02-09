package tn.esprit.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Emprunt;
import tn.esprit.demo.entities.User;
import tn.esprit.demo.repository.BookRepository;
import tn.esprit.demo.repository.EmpruntRepository;
import tn.esprit.demo.repository.UserRepository;

@Service
public class EmpruntServiceImpl {

	@Autowired
	private EmpruntRepository erepository;
	@Autowired
	private BookRepository brepository;
	@Autowired
	private UserRepository urepository;
	
	public List<Emprunt> getAll(){
		return erepository.findAll();
	}
	public String emprunter (Long bookId,Long userId) {
		if(number(userId)!= 0) {
			return "vous avez deja un emprunt";
		}else {
			Book b=new Book();
			User u=new User();
			Emprunt e=new Emprunt();
			b=brepository.findById(bookId).get();
			u=urepository.findById(userId).get();
			e.setBook(b);
			e.setUser(u);
			Date currentUtilDate = new Date();
			e.setIssueTime(currentUtilDate);
			e.setRenew_count(0);
			erepository.save(e);
			b.setAvail(false);
			brepository.save(b);
			return "succes emprunt";
		}
	}
	
	public int number(Long userId) {
		User u=new User();
		u=urepository.findById(userId).get();
		List<Emprunt> l=new ArrayList<>();
		l=erepository.findAll();
		Iterator<Emprunt> it=l.iterator();
		int count=0;
		while(it.hasNext()) {
			Emprunt em=it.next();
			if(em.getUser()==u) {
				count++;
			}
		}
		return count;
	}
	
	public int renewEmprunt (Long bookId) {
		return erepository.renewOperation(bookId);
	}
	
	public int delete(Long bookId) {
		return this.erepository.delete(bookId);
	}
	public long countEmp() {
		return erepository.count();
	}
	public long nbEmpruntParUser(Long idUser) {
		User u=urepository.findById(idUser).orElse(null);
		return erepository.nbEmpUser(u);
	}
	public long nbBooks() {
		return brepository.count();
	}

}
