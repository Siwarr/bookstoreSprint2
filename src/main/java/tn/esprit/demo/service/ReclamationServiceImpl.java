package tn.esprit.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Reclamation;
import tn.esprit.demo.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	private static final Logger L=LogManager.getLogger(ReclamationServiceImpl.class);
	@Autowired
	ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> reclamations=(List<Reclamation>)reclamationRepository.findAll();
		for (Reclamation rec:reclamations)
			L.info("reclamation+++"+rec.toString());
		
		return reclamations;
		
		
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		 L.info("added Reclamation");
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(String id) {
		reclamationRepository.deleteById(Long.parseLong(id));
		L.info("Reclamation deleted");
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		L.info("Reclamation updated");
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(String id) {
		L.info("Reclamation retrieved");
		return reclamationRepository.findById(Long.parseLong(id)).orElse(null);
	}
	
	
}
