package com.valuedge.scsc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valuedge.scsc.entities.TrafficVoilations;

public interface TrafficVoilationRepository extends JpaRepository<TrafficVoilations,Integer> {

	TrafficVoilations findByUserId(String userId);
	
	@Query(value = "SELECT MAX(t.voilationId) FROM TrafficVoilations t WHERE t.userId =?1")
	String findByVoilationId(String userId);

}
