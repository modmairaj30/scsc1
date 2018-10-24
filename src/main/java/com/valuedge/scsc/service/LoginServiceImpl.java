package com.valuedge.scsc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.entities.LoginDetails;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.entities.UserDetails;
import com.valuedge.scsc.exception.ResourceNotFoundException;
import com.valuedge.scsc.repositories.LoginRepository;
import com.valuedge.scsc.repositories.UserDetailRepository;
import com.valuedge.scsc.repositories.UserRepository;
import com.valuedge.scsc.vo.LoginDetailReportVO;
import com.valuedge.scsc.vo.LoginDetailsVO;
import com.valuedge.scsc.vo.ReportVO;
import com.valuedge.scsc.vo.UserDetailReportVO;

@Service
public class LoginServiceImpl implements LoginService {
	Base64.Decoder decoder = Base64.getDecoder();
	@Autowired
	UserRepository userRepo;
	@Autowired
	LoginRepository loginRepo;

	@Autowired
	UserDetailRepository userDetailsRep;

	public LoginDetailsVO login(LoginDetailsVO loginIdVO) {
		
		LoginDetailsVO res= new LoginDetailsVO();
		Optional<User> user = userRepo.findByUserName(loginIdVO.getUserName());
		
		LoginDetails login_id = loginRepo.findByLoginStatus(user.get().getUserId());
		String newLoginId;
		if(login_id==null) {
			newLoginId=	firstLogin(loginIdVO, user);
		
		}
		else {
			newLoginId=	logoutForceFully(loginIdVO,login_id,user);
		}
		res.setLoginId(Integer.parseInt(newLoginId));
		res.setUserId(user.get().getUserId());
		return res;
		
	}

	public String firstLogin(LoginDetailsVO loginIdVO,Optional<User> user) {
		LocalDateTime now = LocalDateTime.now();
		Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
		Date presentTime = Date.from(instant);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String presentDate = sdf.format(presentTime);
		Date loginDate = presentTime;
		try {
			loginDate = sdf.parse(presentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginTime(presentTime);
		loginDetails.setUserId(user.get().getUserId());
		loginDetails.setLoginDate(loginDate);
		loginDetails.setLoginStatus("Logged In");
		loginDetails.setLoginLattitude(loginIdVO.getLoginLattitude());
		loginDetails.setLoginLongitude(loginIdVO.getLoginLongitude());
		LoginDetails newlog=loginRepo.save(loginDetails);
		String loginId = newlog.getLoginId()+"";
		return loginId;
		
	}
	public String logoutForceFully(LoginDetailsVO loginIdVO,LoginDetails login_id,Optional<User> user ) {
		String loginId=null;
		if(login_id.getLogoutDate()==null) {
			LoginDetails loginUpdate = loginRepo.findById(login_id.getLoginId())
					.orElseThrow(() -> new ResourceNotFoundException("LoginDetails", "loginId", login_id.getLoginId()));
				
		/*	String sDate6 = login_id.getLoginDate().getDate()+"-"+(login_id.getLoginDate().getMonth()+1)+"-"+login_id.getLoginDate().getYear()+" 23:00:00";
			SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-YYYY HH:mm:ss"); 
			Date date6=null;
			try {
				date6 = formatter6.parse(sDate6);
			} catch (ParseException e1) {
			e1.printStackTrace();
			}  
	       
	         System.out.println("Converted date is : " + date6);
		 */
				try {
					
					loginUpdate.setLogoutTime(loginUpdate.getLoginDate());
					loginUpdate.setLoginStatus("Logged Out");
					loginUpdate.setLogoutDate(loginUpdate.getLoginDate());
					loginRepo.save(loginUpdate);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				loginId = firstLogin(loginIdVO, user);	
		}
		else {
			
			loginId = firstLogin(loginIdVO, user);
						
		}
		return loginId;
	}
	
	public String logout(LoginDetailsVO logoutVO) {
		LoginDetails loginUpdate = loginRepo.findById(logoutVO.getLoginId())
				.orElseThrow(() -> new ResourceNotFoundException("LoginDetails", "loginId", logoutVO.getLoginId()));
		
		if (loginUpdate.getLoginStatus().equals("Logged In")) {
			
			System.out.println(logoutVO.getLoginId());
			LocalDateTime now = LocalDateTime.now();
			Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
			Date presentTime = Date.from(instant);
			Date loginTime = loginUpdate.getLoginTime();
			Date logoutTime = presentTime;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String presentDate = sdf.format(presentTime);
			Date logoutDate = presentTime;
			
			loginUpdate.setLogoutTime(logoutTime);
			loginUpdate.setLogoutLattitude(logoutVO.getLogoutLattitude());
			loginUpdate.setLogoutLongitude(logoutVO.getLogoutLattitude());
			loginUpdate.setLoginLocation(logoutVO.getLoginLocation());
			loginUpdate.setLoginStatus("Logged Out");
			loginUpdate.setLogoutDate(logoutDate);
			long diff = logoutTime.getTime() - loginTime.getTime();
			long loginHours = diff / (60 * 60 * 1000) % 24;
			long loginMin = diff / (60 * 1000) % 60;
			long loginSec = diff / 1000 % 60;
			Date dt = new Date(diff);
			System.out.println(dt);
			Date date_diff = new Date(diff);
			System.out.println(date_diff.toString());

			String hh = Long.toString(loginHours);
			String MM = Long.toString(loginMin);
			String ss = Long.toString(loginSec);
			loginUpdate.setLoginHours(hh + ":" + MM + ":" + ss);
			loginRepo.save(loginUpdate);
			return "Logged Out";
		} else {
			return "Already Logged Out.";
		}
	}

	@Override
	public List<LoginDetails> getLoginDetails(LoginDetailsVO loginIdVO) {
		return loginRepo.findByUserId(loginIdVO.getUserId());
	}

	@Override
	public String getLoginId(LoginDetailsVO loginIdVO) {
		String loginId1 = loginRepo.findByLoginId(loginIdVO.getUserId());
		return loginId1;
	}

	@Override
	public List<LoginDetailReportVO> getLoginRepot(ReportVO reportVO) {
		List<UserDetails> userList = userDetailsRep.getLoginReport(reportVO.getFromDate(), reportVO.getToDate());
		List<LoginDetailReportVO> lr = new ArrayList<LoginDetailReportVO>();
//		java.util.Iterator<LoginDetailReportVO> itr=lr.iterator();
//		while(itr.hasNext()) {
//			System.out.println(x);
//		}
		for (UserDetails objsrc : userList) {
			LoginDetailReportVO objtar = new LoginDetailReportVO();
			BeanUtils.copyProperties(objsrc, objtar);
			lr.add(objtar);
		}	
		return lr;
	}

	@Override
	public List<UserDetailReportVO> getLoginDetailRepot(ReportVO reportVO) {
		List<LoginDetails> ld = loginRepo.findByUserIdReturnStream(reportVO.getUserId(), reportVO.getFromDate(),
				reportVO.getToDate());

		List<UserDetailReportVO> lr = new ArrayList<UserDetailReportVO>();
		for (LoginDetails objsrc : ld) {
			UserDetailReportVO objtar = new UserDetailReportVO();
			BeanUtils.copyProperties(objsrc, objtar);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String presentDate = sdf.format(objtar.getLoginDate());
			String loginDate = presentDate;
			objtar.setsLoginDate(loginDate);
			
			lr.add(objtar);
			}
		return lr;
	}

}
