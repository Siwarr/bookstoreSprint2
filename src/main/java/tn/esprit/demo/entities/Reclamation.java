package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Reclamation")
public class Reclamation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Reclamation_ID")
	private long id;
	
	@Column(name="Reclamation_TITLE")
	private String titre;
	
	@Column(name="Reclamation_DESCRIPTION")
	private String description;
	
	@Column(name="Reclamation_DATE")
	@Temporal(TemporalType.DATE)
	private Date ReclamationDate;
	
	@ManyToOne
	@JoinColumn(name="FK_USER_ID")
	private Utilisateur user;
	
	
	public Reclamation() {
		super();
	}
	
	

	public Reclamation(String titre, String description, Date reclamationDate) {
		super();
		this.titre = titre;
		this.description = description;
		ReclamationDate = reclamationDate;
	}



	public Reclamation(long id, String titre, String description, Date ReclamationDate) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.ReclamationDate = ReclamationDate;
	}
	
	

	public Reclamation(long id, String titre, String description, Date ReclamationDate, Utilisateur user) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.ReclamationDate = ReclamationDate;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReclamationDate() {
		return ReclamationDate;
	}

	public void setDate(Date ReclamationDate) {
		this.ReclamationDate = ReclamationDate;
	}
	

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", titre=" + titre + ", description=" + description + ", ReclamationDate=" + ReclamationDate
				+ ", user=" + "]";
	}

	
	
	
	

}
