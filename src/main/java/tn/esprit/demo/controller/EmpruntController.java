package tn.esprit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Emprunt;
import tn.esprit.demo.service.EmpruntServiceImpl;

@RestController
public class EmpruntController {

	@Autowired
	private EmpruntServiceImpl service;
	
	@GetMapping("/emprunts")
	public List<Emprunt> findAllEmprunts(){
		return service.getAll();
	}
	@GetMapping("/emprunter/{bId}/{uId}")
	public String emprunter(@PathVariable("bId") Long id,@PathVariable("uId") Long uID){
		return service.emprunter(id,uID);
	}
	
	@GetMapping("/number/{uId}")
	public int number(@PathVariable("uId") Long uID){
		return service.number(uID);
	}
	
	
	
	/*
	@GetMapping("/emprunts/{memberId}")
	public List<Emprunt> findMesEmprunts(@PathVariable("memberId")Long memberId){
		return service.getByUserId(memberId);
	}
	
	@PostMapping("/book/{memberId}/{bookId}/emprunter")
	public String emprunter(@PathVariable("memberId")Long memberId,@PathVariable("bookId")Long bookId) {
		service.emprunter(memberId, bookId);
		return "livre emprunté avec succes";
	}
	*/
}
