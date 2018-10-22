package com.valuedge.scsc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.valuedge.scsc.entities.OTP;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.vo.UserVO;

public interface UserService {
	List<User> getUsers();
	//UserVO getUserByUserName(UserVO userName);
	UserVO getUserByEmailId(String emailId);
	UserVO getUserByMobileNo(String mobileNo);
	String UserRegister(UserVO userVO);
	UserVO getUserByUserName(String userName);
	UserVO passwordUpdate(UserVO userVO);
	UserVO forgotPassword(OTP otp,UserVO userVO);
}
