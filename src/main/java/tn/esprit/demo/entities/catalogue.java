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
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
		
		@Entity
		@Table(name="book_Catalogue")

		public  class catalogue implements Serializable {
			
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue (strategy = GenerationType.IDENTITY)
			private long id;
			@Column(name="Titre")
			private String titre;
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
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
			
			public catalogue(long id, String titre) {
				super();
				this.id = id;
				this.titre = titre;
			}
			 public catalogue(){ 
				super() ;
				 }
		
			@Override
			public String toString() {
				return "catalogue [id=" + id + ", titre=" + titre + "]";
			}
			
			
			
			
			
			
	
	
}
