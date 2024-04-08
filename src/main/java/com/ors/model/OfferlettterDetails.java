package com.ors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OfferlettterDetails {
	
	public OfferlettterDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slno;
	
	@OneToOne
	private User user;
	private Integer offerletterofffered;
	
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getOfferletterofffered() {
		return offerletterofffered;
	}
	public void setOfferletterofffered(Integer offerletterofffered) {
		this.offerletterofffered = offerletterofffered;
	}
	public OfferlettterDetails(Integer slno, User user, Integer offerletterofffered) {
		super();
		this.slno = slno;
		this.user = user;
		this.offerletterofffered = offerletterofffered;
	}
	@Override
	public String toString() {
		return "OfferlettterDetails [slno=" + slno + ", user=" + user + ", Offerletterofffered=" + offerletterofffered
				+ "]";
	}
	
	

}
