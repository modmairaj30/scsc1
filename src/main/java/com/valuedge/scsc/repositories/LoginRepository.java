package com.valuedge.scsc.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
//import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valuedge.scsc.entities.LoginDetails;
import com.valuedge.scsc.vo.LoginDetailsVO;

public interface LoginRepository extends JpaRepository<LoginDetails,Integer>{

	@Query(value = "select max(l.loginId) from LoginDetails l where l.userId =?1")
	String findByLoginId(String userId);


	List<LoginDetails> findByUserId(String userId);


	void save(Optional<LoginDetails> loginUpdate);
	
	 @Query("SELECT c FROM LoginDetails c WHERE c.userId = :userId AND loginDate BETWEEN :fromdate AND :todate")
	 List<LoginDetails> findByUserIdReturnStream(@Param("userId") String userId,@Param("fromdate") Date fromdate, @Param("todate") Date todate);
	//@Query(value="SELECT DATE_FORMAT(login_date,'%m-%d-%Y') as login_date,login_id, login_hours, login_lattitude, login_location, login_longitude, login_status, login_time, logout_lattitude, logout_longitude, logout_time FROM login_details l where user_id='TRV2' and login_date between '2018-09-16' and '2018-09-17';",nativeQuery = true)
	//List<LoginDetails> findByUserIdReturnStream( String userId, Date fromdate,  Date todate);

	 //@Query(value = "select max(l.loginId) as l.loginId,l.logoutDate from LoginDetails l where l.userId =?1 ")
	 @Query(value = "SELECT p FROM LoginDetails p WHERE p.userId=?1 AND p.loginId = (SELECT MAX(p.loginId) FROM p)")
	 LoginDetails findByLoginStatus(String userId);

	// @Query(value = "select max(l.loginId),l.loginStatus from LoginDetails l where l.userId =?1 and l.loginStatus=?2")
	//LoginDetailsVO findByLoginStatus(String userId, String status);
	
}
