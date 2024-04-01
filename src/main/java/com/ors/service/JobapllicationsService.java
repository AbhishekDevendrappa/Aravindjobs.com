package com.ors.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ors.model.Jobapllications;
import com.ors.model.Recruiter;
import com.ors.repo.jobapplicationsrepo;

import java.util.List;

@Service
public class JobapllicationsService {

	@Autowired
	jobapplicationsrepo jobapplicationsrepo;

	public void saveJobs(Jobapllications j) {
		jobapplicationsrepo.save(j);
		
	}

	public List<Jobapllications> getjobapplied(Recruiter r) {
	 List<Jobapllications> j =	jobapplicationsrepo.getbyrecruiter(r);
		return j;
		
	}

	public void deletebyid(Integer no) {
		jobapplicationsrepo.deleteById(no);
		
	}
	
	

}
