package com.ors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jobs {
	
	
	public Jobs() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slno;
	private String company;
	private String jobtitle;
	private String jobdescription;
	private String joblocation;
	private String jobtype;
	
	@ManyToOne
//	@JoinColumn(name="slno")
	private Recruiter recruiter;

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getJoblocation() {
		return joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public Jobs(Integer slno, String company, String jobtitle, String jobdescription, String joblocation,
			String jobtype, Recruiter recruiter) {
		super();
		this.slno = slno;
		this.company = company;
		this.jobtitle = jobtitle;
		this.jobdescription = jobdescription;
		this.joblocation = joblocation;
		this.jobtype = jobtype;
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return "Jobs [slno=" + slno + ", company=" + company + ", jobtitle=" + jobtitle + ", jobdescription="
				+ jobdescription + ", joblocation=" + joblocation + ", jobtype=" + jobtype + ", recruiter=" + recruiter
				+ "]";
	}
	
	

}
