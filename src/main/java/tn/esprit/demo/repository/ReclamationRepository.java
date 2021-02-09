package tn.esprit.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Reclamation;
import tn.esprit.demo.entities.User;

@Repository
public interface ReclamationRepository extends CrudRepository <Reclamation,Long>{

	List<Reclamation> findAllByOrderByDateDesc(Pageable page);
	List<Reclamation> findByUserOrderByDateDesc(User u);
	List<Reclamation> findByDate(Date date);
	List<Reclamation> findByDateBetween(Date date1,Date date2);
	List<Reclamation> findByTitreContainingOrderByDateDesc(String txt);
	List<Reclamation> findTop3ByUserOrderByDateDesc(User u);
	
	@Query("SELECT COUNT(r) FROM Reclamation r WHERE r.user=:user")
	long countByUser(@Param("user")User u);
     
	List<Reclamation> findByUserInOrderByDateDesc(List <User> users);
	
	//Another Method
	//Named parameters
	@Query("SELECT r FROM Reclamation r WHERE r.user.nom LIKE %:nom%")
	List<Reclamation> searchByUserName(@Param("nom")String nom);
	
	//deletebyUser
	List<Reclamation> removeByUser(User u);
	
	@Query("SELECT DISTINCT r.user.nom FROM Reclamation r ")
	List<String> usersReclamationLastNames();
}