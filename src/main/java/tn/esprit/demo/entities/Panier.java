package tn.esprit.demo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PANIER")
public class Panier implements Serializable {

	
	private static final long serialVersionUID = 754989006313761193L;
	
	@EmbeddedId
	private PanierPK panierPK;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false,updatable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idBook", referencedColumnName = "id", insertable = false,updatable=false)
	private Book book;

	private int quantity;
	private float prixT;
	private Boolean isValid;

	
	public float getPrixT() {
		return prixT;
	}

	public void setPrixT(float prixT) {
		this.prixT = prixT;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPanierPK(PanierPK panierPK) {
		this.panierPK = panierPK;
	}

	public PanierPK getPanierPK() {
		return panierPK;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getUser() {
		return user.toString();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBook() {
		return book.toString();
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Panier [panierPK=" + panierPK + ", user=" + user + ", book=" + book + ", quantity=" + quantity
				+ ", prixT=" + prixT + ", isValid=" + isValid + "]";
	}
	
	
}
