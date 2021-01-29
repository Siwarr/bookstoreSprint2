package tn.esprit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.demo.entities.Reclamation;

import tn.esprit.demo.service.IReclamationService;

@RestController
public class ReclamationRestController {
	
	@Autowired
	IReclamationService reclamationService;
	
	// http://localhost:8081/bookstore/servlet/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations(){
		return reclamationService.retrieveAllReclamations();
	}
	
	// Ajouter User : http://localhost:8081/bookstore/servlet/add-reclamation
	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addReclamation (@RequestBody Reclamation r) {
		return reclamationService.addReclamation(r) ;
	}
	
	// http://localhost:8081/bookstore/servlet/retrieve-reclamation/{reclamation-id}
		@GetMapping("/retrieve-reclamation/{reclamation-id}")
		@ResponseBody
		public Reclamation retrieveReclamation (@PathVariable("reclamation-id")String reclamationId ) {
		return reclamationService.retrieveReclamation(reclamationId);
		}
	

}
