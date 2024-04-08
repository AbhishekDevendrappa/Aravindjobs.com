package com.ors.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ors.model.OfferlettterDetails;

@Repository
public interface OfferletterDetailsrepo extends CrudRepository<OfferlettterDetails, Integer> {

	@Query("from OfferlettterDetails where user.slno=:no")
	public OfferlettterDetails getByID(Integer no);

}
