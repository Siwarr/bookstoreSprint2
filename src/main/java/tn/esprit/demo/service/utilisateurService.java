package tn.esprit.demo.service;

import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Utilisateur;

import java.util.List;
import java.util.Optional;


@Service
public interface utilisateurService {
    boolean adduser(Utilisateur u);
    
    List<Utilisateur> findAllusers();
    boolean findById(int id);
    boolean deleteuser(String login);
    Utilisateur findbyLogin(String login);
	boolean updateUser(Utilisateur u, int id);

	Optional<Utilisateur> retrieveUser(Integer id);
}
