package com.ors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ors.model.Jobs;
import com.ors.repo.Jobsrepo;

@Service
public class jobsService {
	
	@Autowired
	Jobsrepo jobsrepo;

	public Jobs saveJobs(Jobs u) {
		return jobsrepo.save(u);
	}

	public  List<Jobs> getAllJobs() {
		 return jobsrepo.findAll();
	}

	public List<Jobs> getByTitle(String jobtitle){
		return (List<Jobs>)jobsrepo.findByTitle(jobtitle);
	}

	public List<Jobs> getAllJob() {
		return (List<Jobs>)jobsrepo.findAll();
	}

	public Optional<Jobs> getjobsby(Integer slno) {
		Optional<Jobs> b =jobsrepo.findById(slno);
		return b;

	}


}
