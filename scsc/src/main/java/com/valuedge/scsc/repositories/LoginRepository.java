package com.valuedge.scsc.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valuedge.scsc.entities.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails,Integer>{

	@Query(value = "select max(l.loginId) from LoginDetails l where l.userId =?1")
	String findByLoginId(String userId);


	List<LoginDetails> findByUserId(String userId);


	void save(Optional<LoginDetails> loginUpdate);
	
	 @Query("SELECT c FROM LoginDetails c WHERE c.userId = :userId AND loginDate BETWEEN :fromdate AND :todate")
	 List<LoginDetails> findByUserIdReturnStream(@Param("userId") String userId,@Param("fromdate") Date fromdate, @Param("todate") Date todate);
	
}
