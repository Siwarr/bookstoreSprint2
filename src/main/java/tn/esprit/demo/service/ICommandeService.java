package tn.esprit.demo.service;

import java.util.List;
//import java.io.IOException;

import tn.esprit.demo.entities.Commande;

public interface ICommandeService {
	
	
	public Commande addCommande(Commande c);
	public List<Commande> getCommandes();
	public Commande getCommandeById(Long id);
	public String deleteCommande(Long id);
	

}
