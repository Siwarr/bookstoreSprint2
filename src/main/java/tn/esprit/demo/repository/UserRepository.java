package tn.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{
	List<User> findByNomContaining(String nom);
}
