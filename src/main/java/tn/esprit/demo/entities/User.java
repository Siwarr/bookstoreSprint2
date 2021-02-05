package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reclamations"})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="USER_LASTNAME")
	private String nom;
	
	@Column(name="USER_FIRSTNAME")
	private String prenom;
	
	@Column(name="USER_MAIL")
	private String mail;
	
	@Column(name="USER_PWD")
	private String pwd;
	
	@Column(name="Inscription_DATE")
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private Set<Reclamation> reclamations;
	

	public User() {
		super();
	}
	

	public User(String nom, String prenom, String mail, String pwd, Date dateInscription, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.dateInscription = dateInscription;
		this.role = role;
	}


	public User(long id, String nom, String prenom, String mail, String pwd, Date dateInscription, Role role,
			Set<Reclamation> reclamations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.pwd = pwd;
		this.dateInscription = dateInscription;
		this.role = role;
		this.reclamations = reclamations;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Set<Reclamation> getReclamations() {
		return reclamations;
	}


	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (role != other.role)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", pwd=" + pwd
				+ ", dateInscription=" + dateInscription + ", role=" + role + "]";
	}

    
	




	
	
	
	
	
}
