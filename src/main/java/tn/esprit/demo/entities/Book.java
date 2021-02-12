package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_BOOK")
public class Book implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -2794327255137815414L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private int stock;
	private float prix;
	
	@OneToMany(mappedBy="book")
	private Set<Panier> paniers;
	
	
	public Book(){
		
	}
	
	

	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public Book(long id, String name, String description, int stock, float prix, Set<Panier> paniers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.prix = prix;
		this.paniers = paniers;
	}



	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", stock=" + stock + ", prix="
				+ prix +"]";
	}

	
	


}
