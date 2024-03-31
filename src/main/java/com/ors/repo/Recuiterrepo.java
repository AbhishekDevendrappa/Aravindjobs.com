package com.ors.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ors.model.Recruiter;

public interface Recuiterrepo extends CrudRepository<Recruiter, Integer> {

	@Query("from Recruiter where email=:email and password=:password")
	public Recruiter getuser(String email, String password);

}
