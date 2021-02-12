package tn.esprit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.demo.entities.Commande;
import tn.esprit.demo.service.CommandeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/Commande")
//*
public class CommandeController {

	@Autowired
	private CommandeServiceImpl service;
	
	@PostMapping("/addCommande")
	public Commande addCommande(@RequestBody Commande b) {
		return service.addCommande(b);
	}
	
	@GetMapping("/Commandes")
	public List<Commande> findAllCommandes(){
		return service.getCommandes();
	}
	@GetMapping("/commande/{id}")
	public Commande findCommandeById(@PathVariable("id") Long id) {
		return service.getCommandeById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCommande(@PathVariable("id") Long id) {
		return service.deleteCommande(id);
	}
}
