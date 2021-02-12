package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class PanierPK implements Serializable {

	private static final long serialVersionUID = -4604848394033279272L;
	
	private int idUser;
	private int idBook;
	private Date dateP;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public Date getDateP() {
		return dateP;
	}
	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}
	public PanierPK(int idUser, int idBook, Date dateP) {
		super();
		this.idUser = idUser;
		this.idBook = idBook;
		this.dateP = dateP;
	}
	public PanierPK() {
		super();
	}
	
	
}
