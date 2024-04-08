package com.ors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slno;
	@OneToOne
	private User user;
	
	
	public Block() {
		// TODO Auto-generated constructor stub
	}

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

	

	@Override
	public String toString() {
		return "Block [slno=" + slno + ", user=" + user + "]";
	}
	
}
