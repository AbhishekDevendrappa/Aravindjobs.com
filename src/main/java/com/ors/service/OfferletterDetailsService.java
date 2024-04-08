package com.ors.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ors.model.OfferlettterDetails;
import com.ors.repo.OfferletterDetailsrepo;

@Service
public class OfferletterDetailsService {

	@Autowired
	OfferletterDetailsrepo offerletterDetailsrepo;
	
	public Object getByslno(Integer no) {
		return offerletterDetailsrepo.getByID(no);
	}

	public void save(OfferlettterDetails find) {
		offerletterDetailsrepo.save(find);
		
	}

	public List<OfferlettterDetails> getall() {
	List<OfferlettterDetails> offers = (List<OfferlettterDetails>) offerletterDetailsrepo.findAll();
		return offers;
	}

}
