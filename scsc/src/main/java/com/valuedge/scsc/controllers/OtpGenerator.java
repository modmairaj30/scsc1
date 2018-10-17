package com.valuedge.scsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.entities.OTP;
import com.valuedge.scsc.service.OtpService;
import com.valuedge.scsc.vo.StatusVo;

@RestController
@RequestMapping
public class OtpGenerator {
	@Autowired
	OtpService otpService;
	@PostMapping(value = "/getOtp")
	public ResponseEntity<?> getSms(@RequestBody  OTP otp) {
		OTP res = otpService.getSms(otp);
	    StatusVo status=new StatusVo();
    	//status.setStatus(res);
    	return ResponseEntity.ok(res);
	}
		
}
