package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","emprunts"})
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private long id;
	@Column(name="BOOK_NAME")
	private String nom;
	@Column(name="BOOK_AUTEUR")
	private String auteur;
	@Column(name="BOOK_DESCRIPTION")
	private String description;
	@Column(name="BOOK_PRICE")
	private float price;
	@Column(name="BOOK_ISAVAIL")
    private boolean isAvail;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="book")
	private Set<Emprunt> emprunts;
    

	public Book() {
		super();
	}
	
	
    
	public Book(String nom, String auteur, String description, float price, boolean isAvail) {
		super();
		this.nom = nom;
		this.auteur = auteur;
		this.description = description;
		this.price = price;
		this.isAvail = isAvail;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvail() {
		return isAvail;
	}
	public void setAvail(boolean isAvail) {
		this.isAvail = isAvail;
	}

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public Book(Long id, String nom, String auteur, String description, float price, boolean isAvail,
			Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.nom = nom;
		this.auteur = auteur;
		this.description = description;
		this.price = price;
		this.isAvail = isAvail;
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", nom=" + nom + ", auteur=" + auteur + ", description=" + description + ", price="
				+ price + ", isAvail=" + isAvail + "]";
	}


	
	
	
	
}