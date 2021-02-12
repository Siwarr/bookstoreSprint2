package tn.esprit.demo.repository;
//**
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import tn.esprit.demo.entities.Commande;


@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
