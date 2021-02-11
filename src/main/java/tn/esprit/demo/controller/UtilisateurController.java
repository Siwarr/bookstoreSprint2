package tn.esprit.demo.controller;



import tn.esprit.demo.entities.Utilisateur;
import tn.esprit.demo.service.utilisateurServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    utilisateurServiceImplementation USI;

    @PostMapping("/adduser")
    public boolean adduser(@RequestBody Utilisateur U){
        return USI.adduser(U);
    }
    @GetMapping("/login")
    public Principal user(Principal principal){
        System.out.println("user Logged"+principal);
        return principal;
    }
    @PostMapping("/deleteuser")
    public boolean deleteuser(@RequestParam(name = "login") String login){
        return USI.deleteuser(login);
    }

   // afficher touts les users http://localhost:8090/bookstore/servlet/retrieve-all-users
    	@GetMapping("/retrieve-all-users")
    	@ResponseBody
    	public List<Utilisateur> getReclamations(){
    		return USI.findAllusers();
    	}
    	@GetMapping("/retrieve-user/{user-id}")
		@ResponseBody
		public Optional<Utilisateur> retrieveReclamation (@PathVariable("userid-id")Integer id ) {
		return USI.retrieveUser(id);
		}



}
