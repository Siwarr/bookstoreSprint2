package tn.esprit.demo.entities;

import java.io.Serializable;
import java.util.Date;

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
	@Column
	private int id;
	/*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "id")*/
	private Book book ;
	/*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId", referencedColumnName = "id")
	//@JsonIgnore*/
	private User user;
	@Temporal (TemporalType.DATE)
	private Date issueTime;
	@Column
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
	public Emprunt() {}
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
	
	
}
