package tn.esprit.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.Panier;
import tn.esprit.demo.entities.PanierPK;
import tn.esprit.demo.entities.User;

@Repository
public interface PanierRepository extends JpaRepository<Panier, PanierPK> {
	
	@Modifying
	@Query(value ="SELECT DISTINCT id,name,description,stock,prix"
			+ " FROM t_book INNER JOIN panier ON t_book.id = panier.id_book "
			+ "where panier.id_user = :uid", nativeQuery = true)
	public List<Object> findAllBookByUser(@Param("uid") int userId);
	
	
	@Query(value ="SELECT DISTINCT id,email,nom,password,prenom"
			+ " FROM t_user INNER JOIN panier ON t_user.id = panier.id_user "
			+ "where panier.id_book = :bid", nativeQuery = true)
	public List<Object> findAllUserByBook(@Param("bid")int bookId);
	
	
	@Query(value ="SELECT * from Panier WHERE id_user = :uid AND is_valid ='false'", nativeQuery = true)
	public List<Panier> findAllNonConfirmedPanierByUser(@Param("uid")int userId);

	
}
