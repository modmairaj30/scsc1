package com.valuedge.scsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.entities.OTP;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.repositories.UserRepository;
import com.valuedge.scsc.service.UserService;
import com.valuedge.scsc.vo.StatusVo;
import com.valuedge.scsc.vo.UserVO;

@RestController
@RequestMapping

public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;

	@GetMapping(value = "/getUsers")
    public List<User> getUsers() {
		
        return userService.getUsers();
    }
	@GetMapping("/getUser/{userName}")
	public ResponseEntity<?> getUser(@PathVariable(value = "userName") String userName) {
	    UserVO res = userService.getUserByUserName(userName);
	    StatusVo status=new StatusVo();
    	//status.setStatus(res);
    	return ResponseEntity.ok(res);
	}
	@PostMapping("/getUserEmailId")
	public ResponseEntity<?> getEmail(@RequestBody UserVO userVO) {
		UserVO res=userService.getUserByEmailId(userVO.getEmailId());
		StatusVo status=new StatusVo();
    	//status.setStatus(res);
    	return ResponseEntity.ok(res);
	}
	@GetMapping("/getUserMobileNo/{mobileNo}")
	public ResponseEntity<?> getMobileNo(@PathVariable(value = "mobileNo") String mobileNo) {
		UserVO res = userService.getUserByMobileNo(mobileNo);
		 StatusVo status=new StatusVo();
	    	//status.setStatus(res);
	    	return ResponseEntity.ok(res);
	}
	@PostMapping("/forgotPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody OTP otp,UserVO userVO) {
//		UserVO userVO = new UserVO();
//		userVO.setMobileNo(mobileNo);
		UserVO res = userService.forgotPassword(otp,userVO);
		 StatusVo status=new StatusVo();
	    	//status.setStatus(res);
	    	return ResponseEntity.ok(res);
	}
	@PostMapping(value = "/saveUser")
    public ResponseEntity<?> UserRegister(@RequestBody UserVO userVO) {
		String res = userService.UserRegister(userVO);
		 StatusVo status=new StatusVo();
	    	status.setStatus(res);
	    	return ResponseEntity.ok(status);
    }
	@PutMapping(value = "/updatePassword")
    public ResponseEntity<?> passwordUpdate(@RequestBody UserVO userVO) {
		UserVO res = userService.passwordUpdate(userVO);
		 StatusVo status=new StatusVo();
	    	status.setStatus("updated");
	    	return ResponseEntity.ok(status);
    }
	
	
}
