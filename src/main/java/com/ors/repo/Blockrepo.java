package com.ors.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ors.model.Block;

@Repository
public interface Blockrepo extends CrudRepository<Block, Integer> {

	@Query("from Block where user.slno=:no")
	public Optional<Block> getByUserId(Integer no);

}
