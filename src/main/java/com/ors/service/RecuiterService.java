package com.ors.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ors.model.Recruiter;
import com.ors.repo.Recuiterrepo;

@Service
public class RecuiterService {
	
	@Autowired
	Recuiterrepo recuiterrepo;

	public void saveRecuiter(Recruiter r) {
		recuiterrepo.save(r);
	}

	public Recruiter getrecuiter(String email, String password) {
		System.out.println(recuiterrepo.getuser(email,password)+" in service");
		return recuiterrepo.getuser(email,password);
	}

	public Recruiter getRecruiterById(Integer slno) {
		Optional<Recruiter> r = recuiterrepo.findById(slno);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}

}
