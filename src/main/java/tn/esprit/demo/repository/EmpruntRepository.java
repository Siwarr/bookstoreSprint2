package tn.esprit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Emprunt;
import tn.esprit.demo.entities.User;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt,Integer>  {

	@Transactional
	@Modifying
	@Query(value="delete from Emprunt e where e.book.id = :bookId")
	int delete (@Param("bookId") Long bookId);
	
	@Query("SELECT COUNT(e) FROM Emprunt e WHERE e.user = :user")
	long nbEmpUser(@Param("user")User u);
}
