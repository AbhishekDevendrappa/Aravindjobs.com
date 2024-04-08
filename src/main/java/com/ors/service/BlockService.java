package com.ors.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ors.model.Block;
import com.ors.repo.Blockrepo;

@Service
public class BlockService {

	
	@Autowired
	Blockrepo blockrepo;
	
	public void save(Block b) {
		blockrepo.save(b);
	}

	public Optional<Block> getbyId(Integer no) {
		return blockrepo.getByUserId(no);
	}

}
