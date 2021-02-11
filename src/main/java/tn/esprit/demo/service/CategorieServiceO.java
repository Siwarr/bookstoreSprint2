package com.esprit.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.entity.categorie;
import com.esprit.demo.entity.ouvrage;
import com.esprit.demo.repository.OuvrageRepository;
import com.esprit.demo.repository.UserRepository;


@Service
public class CategorieServiceO implements CategorieService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	private static final Logger l = LogManager.getLogger(CategorieServiceO.class);
	
	public List getCategorieParNbrOuvrage() {
		return ouvrageRepository.OuvragePrCategorie();
	}

	
	public List getQTEParNbrOuvrage() {
		return ouvrageRepository.OuvragePrQte();
	}
	@Override
	public categorie addcategorie(categorie c) {
		
		userRepository.save(c);
		return c;
		
	}

		
	public String deletecategorie(long id) {

		userRepository.deleteById(id);
		return "Categorie removed ||"+id;
		
		
	}

	@Override
	public categorie updatecategorie(categorie c) {
		
		userRepository.save(c);
		return c;
		
	}

	@Override
	public categorie retrievecategorie(long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public List<categorie> retrieveAllCategorie() {
				
			List<categorie> categories = (List<categorie>)userRepository.findAll();
			
			for (categorie Categorie : categories)
			{
				l.info("categorie +++ : "+ Categorie);
			}
				
			return categories;
		}

		
		
	}


