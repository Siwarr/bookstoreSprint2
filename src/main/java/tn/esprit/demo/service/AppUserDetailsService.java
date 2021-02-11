package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.demo.entities.Utilisateur;


@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    utilisateurService US;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Utilisateur User = US.findbyLogin(s);
        System.out.println("************** LoadUserByUsername Success **************");
        return (UserDetails) User ;
    }
}
