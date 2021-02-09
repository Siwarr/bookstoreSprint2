package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;
import tn.esprit.demo.entities.Book;
import tn.esprit.demo.entities.User;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprunt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="EMPRUNT_ID")
	private int id;
	@ManyToOne
    @JoinColumn(name = "FK_BOOK_ID")
	private Book book;
	
	@ManyToOne
    @JoinColumn(name = "FK_MEMBER_ID")
	//@JsonIgnore
	private User user;
	
	@Column(name="EMPRUNT_ISSUETIME")
	@Temporal (TemporalType.DATE)
	private Date issueTime;
	@Column(name="EMPRUNT_RENEW_COUNT")
	private int renew_count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}
	public int getRenew_count() {
		return renew_count;
	}
	public void setRenew_count(int renew_count) {
		this.renew_count = renew_count;
	}
	public Emprunt() {
		super();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", book=" + book + ", user=" + user + ", issueTime=" + issueTime + ", renew_count="
				+ renew_count + "]";
	}
	public Emprunt(int id, Book book, User user, Date issueTime, int renew_count) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.issueTime = issueTime;
		this.renew_count = renew_count;
	}
	
	
	
}
