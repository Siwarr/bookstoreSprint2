package com.esprit.demo.entity;


	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

		
		@Entity
		@Table(name="book_Ouvrage")

		public  class ouvrage implements Serializable {
			
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue (strategy = GenerationType.IDENTITY)
			private long id;
			@Column(name="Name")
			private String name;
			@Column(name="Edition")
			private String edition;
			@Column(name="Quantité")
			private long Quantité;
			@Column(name="id_cat")
			private long id_cat;
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
			public String getEdition() {
				return edition;
			}
			public void setEdition(String edition) {
				this.edition = edition;
			}
			public long getQuantité() {
				return Quantité;
			}
			public void setQuantité(long quantité) {
				Quantité = quantité;
			}
			public long getId_cat() {
				return id_cat;
			}
			public void setId_cat(long id_cat) {
				this.id_cat = id_cat;
			}
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
			@Override
			public String toString() {
				return "ouvrage [id=" + id + ", name=" + name + ", edition=" + edition + ", Quantité=" + Quantité
						+ ", id_cat=" + id_cat + "]";
			}
			public ouvrage(long id, String name, String edition, long quantité, long id_cat) {
				super();
				this.id = id;
				this.name = name;
				this.edition = edition;
				Quantité = quantité;
				this.id_cat = id_cat;
			}
			
			
			public ouvrage() {
				super();
			}
			
			@ManyToOne
			categorie Categorie;
			
			public categorie getCategorie() {
				return Categorie;
			}
			public void setCategorie(categorie categorie) {
				Categorie = categorie;
			} 
			
			

}
