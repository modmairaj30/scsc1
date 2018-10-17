package com.valuedge.scsc.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valuedge.scsc.entities.UserDetails;

public interface UserDetailRepository extends JpaRepository<UserDetails,Integer>{

	
	
	/*@Query("SELECT  u FROM UserDetails u  WHERE loginDate BETWEEN :fromdate AND :todate GROUP BY userId")
	 List<UserDetails> getLoginReport(@Param("fromdate") Date fromdate, @Param("todate") Date todate);*/

	
	 @Query(value = "SELECT *,concat('',sec_to_time(sum(login_hours))) as total FROM view_get_login_details  where  login_date between :fromdate and  :todate group by user_id order by user_id", nativeQuery = true)
	 List<UserDetails> getLoginReport(@Param("fromdate") Date fromdate, @Param("todate") Date todate);
	

}
