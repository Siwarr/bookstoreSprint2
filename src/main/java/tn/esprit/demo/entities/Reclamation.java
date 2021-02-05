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
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="FK_USER_ID")
	private User user;
	
	
	public Reclamation() {
		super();
	}
	
	

	public Reclamation(String titre, String description, Date Reclamationdate) {
		super();
		this.titre = titre;
		this.description = description;
		this.date = Reclamationdate;
	}



	public Reclamation(long id, String titre, String description, Date ReclamationDate) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.date = ReclamationDate;
	}
	
	

	public Reclamation(long id, String titre, String description, Date ReclamationDate, User user) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.date = ReclamationDate;
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
		return date;
	}

	public void setDate(Date ReclamationDate) {
		this.date = ReclamationDate;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", titre=" + titre + ", description=" + description + ", ReclamationDate=" + date
				+ ", user=" +user+ "]";
	}

	
	
	
	

}
