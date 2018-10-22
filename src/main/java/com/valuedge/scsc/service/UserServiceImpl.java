package com.valuedge.scsc.service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.controllers.OtpGenerator;
import com.valuedge.scsc.entities.OTP;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.exception.ResourceNotFoundException;
import com.valuedge.scsc.repositories.UserRepository;
import com.valuedge.scsc.vo.UserVO;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserService{
	Base64.Encoder encoder = Base64.getMimeEncoder();
	@Autowired
	UserRepository userRepo;
	@Autowired
	OtpService otpService;
	 public List<User> getUsers() {
			
	        return userRepo.findAll();
	    }
	 public UserVO getUserByUserName(String userName) {
		    Optional<User> user = userRepo.findByUserName(userName);
		    UserVO uservo = new UserVO();
		    if(user.isPresent()) {
		    uservo.setRes("Exists");
		    uservo.setUserName(user.get().getUserName());
		    return uservo;
		    }else {
		    	uservo.setRes("Does'n Exists");
			    return uservo;
		    }
		}
	 public UserVO getUserByEmailId(String emailId) {
		  Optional<User> user = userRepo.findByEmailId(emailId);
		  UserVO uservo = new UserVO();
		  if(user.isPresent()) {
		    uservo.setRes("Exists");
		    return uservo;
		    }else {
		    	uservo.setRes("Does'n Exists");
		    	return uservo;
		    } 
		}
	 public UserVO getUserByMobileNo(String mobileNo) {
		 Optional<User> user = userRepo.findByMobileNo(mobileNo);
		 UserVO uservo = new UserVO();
		    if(user.isPresent()) {
		    uservo.setRes("Exists");
		    return uservo;
		    }else {
		    	uservo.setRes("Does'n Exists");
		    	return uservo;
		    } 
		}
	 public String UserRegister(UserVO userVO) {
			User res_user = new User();
				Optional<User> user1=userRepo.findByUserName(userVO.getUserName());
				   if (!(user1.isPresent())) {
					   User u = new User();
					   u.setUserName(userVO.getUserName());
					   //u.setPassword(Base64.getEncoder().withoutPadding().encodeToString(userVO.getPassword().getBytes()));
					   String password = "password";
						BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
						u.setPassword(passwordEncoder.encode(userVO.getPassword()));

					   u.setEmailId(userVO.getEmailId());
					   u.setCompany(userVO.getCompany());
					   u.setName(userVO.getName());
					   u.setMobileNo(userVO.getMobileNo());
					 res_user=  userRepo.save(u);
					 	return "User Resistered Successfully";
				   	}	
				   else {
					   return "User already exists";
				   }				  
	    }
	 public UserVO forgotPassword(OTP otp,UserVO userVO) {
			OTP otp1 = new OTP();
				Optional<User> user1=userRepo.findByMobileNo(otp.getMobileNo());
				   if ((user1.isPresent())) {
					   otp1.setMobileNo(user1.get().getMobileNo());
					   otp1.setOtp(otp.getOtp());
					   otpService.getSms(otp1);
					   userVO.setUserId(user1.get().getUserId());
					   userVO.setOtp(otp.getOtp());
					   return userVO;
					  
				   	}	
				   else {
					   userVO.setRes("User doesn't exists");
					   return userVO;
				   }				  
	    }
	 public UserVO passwordUpdate(UserVO userVO) {
		 User userUpdate = userRepo.findById(userVO.getUserId())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "userName",userVO.getUserName() ));
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 userUpdate.setPassword(passwordEncoder.encode(userVO.getPassword()));
		   userRepo.save(userUpdate);
		   userVO.setRes("Password updated");
		 	return userVO;
	 }
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(userName);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), getAuthority());
	}
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
}
