package tn.esprit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository <Reclamation,Long>{

}
