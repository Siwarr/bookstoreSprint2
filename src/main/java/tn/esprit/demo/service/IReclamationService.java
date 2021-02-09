package tn.esprit.demo.service;

import java.text.ParseException;
import java.util.List;

import tn.esprit.demo.entities.Reclamation;


public interface IReclamationService {
	
    List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation (String id);
	Reclamation updateReclamation (Reclamation r);
	Reclamation retrieveReclamation (String id);
	
	List<Reclamation> findReclamationByUser(String id);
	List<Reclamation> findReclamationByDate(String date) throws ParseException;
	List<Reclamation> findReclamationByDateBetween(String date1,String date2) throws ParseException;
	List<Reclamation> findReclamationByTitleContaining(String txt);
	
	List<Reclamation> findReclamationByUserNameLike(String nom);
	List<Reclamation> deleteReclamationByUser(String id);
	
	List<Reclamation> retrieveAllReclamationsLimit3();
	List<Reclamation> findReclamationByUserLimit(String id);
	long countReclamation();
	long countReclamationByUser(String idUser);
	
	List<String> usersReclamationLastNames();
}