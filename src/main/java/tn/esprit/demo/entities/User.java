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
@Table(name="T_USER")
public class User implements Serializable{

	private static final long serialVersionUID = 772299985077937753L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String prenom;
	private String nom;
	private String email;
	private String password;


	@OneToMany(mappedBy="user")
	private Set<Panier> paniers;

	public User(){
		
	}

	public User(int id, String prenom, String nom, String email, String password) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;

	}

	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	


	}

