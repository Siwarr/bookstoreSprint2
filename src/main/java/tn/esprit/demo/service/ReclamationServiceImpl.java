package tn.esprit.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Reclamation;
import tn.esprit.demo.entities.User;
import tn.esprit.demo.repository.ReclamationRepository;
import tn.esprit.demo.repository.UserRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	private static final Logger L=LogManager.getLogger(ReclamationServiceImpl.class);
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	UserRepository userRepository;
	
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
		L.info(reclamationRepository.findById(Long.parseLong(id)).orElse(null));
		return reclamationRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public List<Reclamation> findReclamationByUser(String id) {
		User u=userRepository.findById(Long.parseLong(id)).orElse(null);
		return reclamationRepository.findByUserOrderByDateDesc(u);
	}

	@Override
	public List<Reclamation> findReclamationByDate(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d=dateFormat.parse(date);
		return reclamationRepository.findByDate(d);
	}

	@Override
	public List<Reclamation> findReclamationByDateBetween(String date1, String date2) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d1=dateFormat.parse(date1);
		Date d2=dateFormat.parse(date2);
		return reclamationRepository.findByDateBetween(d1, d2);
	}

	@Override
	public List<Reclamation> findReclamationByTitleContaining(String txt) {
		return reclamationRepository.findByTitreContainingOrderByDateDesc(txt);
	}

	@Override
	public List<Reclamation> findReclamationByUserNameLike(String nom) {
		List<User>users=userRepository.findByNomContaining(nom);
		return reclamationRepository.findByUserInOrderByDateDesc(users);
		//return reclamationRepository.searchByUserName(nom);
	}

	@Override
	public List<Reclamation> deleteReclamationByUser(String id) {
		User u=userRepository.findById(Long.parseLong(id)).orElse(null);
		return reclamationRepository.removeByUser(u);
	}

	@Override
	public List<Reclamation> retrieveAllReclamationsLimit3() {
		Pageable page3=PageRequest.of(0,3);
		List<Reclamation> reclamations=(List<Reclamation>)reclamationRepository.findAllByOrderByDateDesc(page3);
		for (Reclamation rec:reclamations)
			L.info("reclamation+++"+rec.toString());
		
		return reclamations;
	}

	@Override
	public List<Reclamation> findReclamationByUserLimit(String id) {
		User u=userRepository.findById(Long.parseLong(id)).orElse(null);
		return reclamationRepository.findTop3ByUserOrderByDateDesc(u);
	}

	@Override
	public long countReclamation() {
		return reclamationRepository.count();
	}

	@Override
	public long countReclamationByUser(String idUser) {
		User u=userRepository.findById(Long.parseLong(idUser)).orElse(null);
		return reclamationRepository.countByUser(u);
		
	}
	
	
}
