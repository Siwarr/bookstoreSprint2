package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


	
	@Entity
	@Table(name="book_Categorie")

	public  class categorie implements Serializable {
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="libellé")
		private String lib;
		@Column(name="Description")
		private String descrip;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getLib() {
			return lib;
		}
		public void setLib(String lib) {
			this.lib = lib;
		}
		public String getDescrip() {
			return descrip;
		}
		public void setDescrip(String descrip) {
			this.descrip = descrip;
		}
		public long getSerialversionuid() {
			return serialVersionUID;
		}
		
			
		public categorie(long id, String lib, String descrip) {
			super();
			this.id = id;
			this.lib = lib;
			this.descrip = descrip;
		}
		
		public categorie() {
			super();
		}
		
		
		@Override
		public String toString() {
			return "categorie [id=" + id + ", lib=" + lib + ", descrip=" + descrip + "]";
		}
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy="Categorie")
		private Set<ouvrage> ouvrages;
		public Set<ouvrage> getOuvrages() {
			return ouvrages;
		}
		public void setOuvrages(Set<ouvrage> ouvrages) {
			this.ouvrages = ouvrages;
		}
		
		
		
		
		
		
	}

		
		
		
		