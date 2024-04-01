package com.ors.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ors.model.Jobapllications;
import com.ors.model.Recruiter;

@Repository
public interface jobapplicationsrepo extends JpaRepository<Jobapllications, Integer> {

	@Query("from Jobapllications where recruiter=:r")
	List<Jobapllications> getbyrecruiter(Recruiter r);
	
	
}
