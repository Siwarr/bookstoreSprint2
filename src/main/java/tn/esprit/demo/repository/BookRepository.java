package tn.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	List<Book> findByNom(String nom);

	
}
