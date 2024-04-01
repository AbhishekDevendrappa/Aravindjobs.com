package com.ors.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

@Entity
public class Jobapllications {

	public Jobapllications() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer slno;
	@ManyToOne
	private Recruiter recruiter;
	@ManyToOne
	private Jobs jobs;
	@ManyToOne
	private User user;
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Jobapllications(Integer slno, Recruiter recruiter, Jobs jobs, User user) {
		super();
		this.slno = slno;
		this.recruiter = recruiter;
		this.jobs = jobs;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Jobapllications [slno=" + slno + ", recruiter=" + recruiter + ", jobs=" + jobs + ", user=" + user + "]";
	}
	
	
}
