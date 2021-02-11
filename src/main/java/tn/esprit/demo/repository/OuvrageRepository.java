package com.esprit.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.ouvrage;
@Repository
public interface OuvrageRepository extends JpaRepository<ouvrage,Long> {
	//un categorie porte ,posssede plusieurs ouvrage exemple categorie dev personnel feha plusieurs ouvarge donc
	
	//count(ouv) compter le nombre d'ouvage
	//(ouv.categorie.libellé) on a recuperee les noms de categories selon l'ouvrage
	//@Query("select (ouv.Categorie.lib) as nom ,count(ouv) as nombre ouvrage from ouvrage ouv Group By (ouv.Categorie.lib)")
	@Query("select count(ouv) as nombre , (ouv.Categorie.lib) as lib from ouvrage ouv Group By (ouv.Categorie.lib)")
	public List OuvragePrCategorie(); 
	
	@Query("select (ouv.name) as nom , (ouv.Quantité) as qte from ouvrage ouv Group By (ouv.Quantité)")
	public List OuvragePrQte(); 
	
}
