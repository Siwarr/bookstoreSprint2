package com.esprit.demo.controller;

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

import com.esprit.demo.entity.categorie;
import com.esprit.demo.entity.ouvrage;
import com.esprit.demo.service.CategorieService;
import com.esprit.demo.service.CategorieServiceO;

@RestController
//@RequestMapping("/ouvrage")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)public class BookController {
	@Autowired
	private CategorieService service;
	@Autowired
	private CategorieServiceO serviceO;
	
	@GetMapping("/getcategoriebyouvrage")//api rest de type get
	public List getcategoriebyOuvrage(){
		return serviceO.getCategorieParNbrOuvrage();
	}
	
	@GetMapping("/getqtebyouvrage")//api rest de type get
	public List getqtebyOuvrage(){
		return serviceO.getQTEParNbrOuvrage();
	}
	@GetMapping("/")//api rest de type get
	public String helo(){
		String ch="helo world";
		return ch;
	}
	
	
	@PostMapping("/addcategorie")
	public categorie addcategorie(@RequestBody categorie c) {
		return service.addcategorie(c);
	}
	
	@GetMapping("/retrieveAllCategorie")
	public List<categorie> findAllcategorie(){
		return service.retrieveAllCategorie();
	}
	@GetMapping("/retrievecategorie/{id}")
	public categorie findCtegorieById(@PathVariable("id") long id) {
		return service.retrievecategorie(id);
	}
	
	@PutMapping("/updatecategorie")
	public categorie updateCategorie(@RequestBody categorie c) {
		return service.updatecategorie(c);
	}

	@DeleteMapping("/deletecategorie/{id}")
	public String deleteCategorie(@PathVariable("id") long id) {
		return service.deletecategorie(id);
	}

}
