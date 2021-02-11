package com.esprit.demo.service;

import java.util.List;

import com.esprit.demo.entity.categorie;

public interface CategorieService {
	
	categorie addcategorie(categorie c);
	String deletecategorie(long id);
	categorie updatecategorie(categorie c);
	categorie retrievecategorie(long id);

	List<categorie> retrieveAllCategorie();
	

}
