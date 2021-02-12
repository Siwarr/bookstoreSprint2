package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.demo.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
