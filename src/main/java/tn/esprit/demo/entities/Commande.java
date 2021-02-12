package tn.esprit.demo.entities;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//*
@Entity
@Table(name="T_COMMANDE")

public class Commande implements Serializable {

	

	
		private static final long serialVersionUID = 1L;
		
		// attributs
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="Commande_NUM")
		private Long num;
		
		@Column(name="Commande_dateOrdered")
		private String dateOrdered;
	
		
		
		public Commande()
	    {
	        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        
	        Date str= new Date(System.currentTimeMillis());
	        this.dateOrdered=format.format(str);
	        
	    }

		
		
		public Commande(Long num, String dateOrdered) {
			super();
			this.num = num;
			this.dateOrdered = dateOrdered;
			
		}
		
		// Getters & Setters 

		public Long getNum() {
			return num;
		}

		public void setNum(Long num) {
			this.num = num;
		}

		public String getDateOrdered() {
			return dateOrdered;
		}

		public void setDateOrdered(String dateOrdered) {
			this.dateOrdered = dateOrdered;
		}

		
		
		// toString()
		
		@Override
		public String toString() {
			return "Commande [num=" + num + ", dateOrdered=" + dateOrdered + "]";
		}
		
		// hasCode()

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((num == null) ? 0 : num.hashCode());
			return result;
		}

		
		// equals()
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Commande other = (Commande) obj;
			if (num == null) {
				if (other.num != null)
					return false;
			} else if (!num.equals(other.num))
				return false;
			return true;
		}
		
		
		
		
		
		
		
		
		
	
}
