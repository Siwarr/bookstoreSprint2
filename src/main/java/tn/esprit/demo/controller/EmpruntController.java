package tn.esprit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Emprunt;
import tn.esprit.demo.service.EmpruntServiceImpl;

@RestController
public class EmpruntController {

	@Autowired
	private EmpruntServiceImpl service;
	
	//http://localhost:8090/emprunts
	@GetMapping("/emprunts")
	public List<Emprunt> findAllEmprunts(){
		return service.getAll();
	}
	//http://localhost:8090/emprunter/1/1
	@GetMapping("/emprunter/{bId}/{uId}")
	public String emprunter(@PathVariable("bId") Long id,@PathVariable("uId") Long uID){
		return service.emprunter(id,uID);
	}
	//http://localhost:8090/number/1
	@GetMapping("/number/{uId}")
	public int number(@PathVariable("uId") Long uID){
		return service.number(uID);
	}
	//http://localhost:8090/retourEmprunt/1
	@DeleteMapping("/retourEmprunt/{bookId}")
	public int retourEmprunt(@PathVariable Long bookId) {
		return service.delete(bookId);
	}
	
	//nbre de livres empruntés par user =u par rapport au nbre demprunts total
	//http://localhost:8090/empruntParUser/1
	@GetMapping("/empruntParUser/{userId}")	
	public String nbEmpruntParUser (@PathVariable("userId")Long userId){
		return "Le nombre demprunts du User avec id= "+userId+ " est : "
				+ service.nbEmpruntParUser(userId)+ "\n Par rapport au nombre total demprunts = "+service.countEmp();
	}

	//nbre de book emprunté par rapport o nbre total des book 
	//http://localhost:8090/nbEmpruntParRapportNbBook
	@GetMapping("/nbEmpruntParRapportNbBook")
	public String EmpruntBook() {
		return "Le nombre de livres empruntés = "+service.countEmp()+
				"\n Par rapport au nombre de livres disponibles = "+service.nbBooks();
	}
}
