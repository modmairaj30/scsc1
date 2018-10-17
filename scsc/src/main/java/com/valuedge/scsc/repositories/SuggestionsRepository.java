package com.valuedge.scsc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valuedge.scsc.entities.Suggestions;

public interface SuggestionsRepository extends JpaRepository<Suggestions,Integer>{

	List<Suggestions> findByUserId(String userId);

}
