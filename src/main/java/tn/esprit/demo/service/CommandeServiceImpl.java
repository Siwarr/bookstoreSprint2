package tn.esprit.demo.service;

import java.util.List;
//*
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Commande;
import tn.esprit.demo.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements ICommandeService {
	
	//private static final Logger L=LogManager.getLogger(CommandeServiceImpl.class);
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Override
	public Commande addCommande(Commande c) {
		return commandeRepository.save(c);
	}
	
	
	@Override
	public List<Commande> getCommandes(){
		return commandeRepository.findAll();
		/*List<Books> books = new ArrayList<Books>();  
		booksRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;  
		}*/
	}
	@Override
	public Commande getCommandeById(Long id){
		return commandeRepository.findById(id).get();
	}
	
	@Override
	public String deleteCommande(Long id) {
		commandeRepository.deleteById(id);
		return "Commande removed ||"+id;
	}
	
	
}
