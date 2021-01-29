package tn.esprit.demo.service;

import java.util.List;

import tn.esprit.demo.entities.Reclamation;


public interface IReclamationService {
	
    List<Reclamation> retrieveAllReclamations();
	
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation (String id);
	Reclamation updateReclamation (Reclamation r);
	Reclamation retrieveReclamation (String id);


}
