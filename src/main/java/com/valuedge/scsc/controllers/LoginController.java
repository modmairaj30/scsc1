package com.valuedge.scsc.controllers;

import java.util.List;

import org.attoparser.config.ParseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.entities.LoginDetails;
import com.valuedge.scsc.service.LoginService;
import com.valuedge.scsc.vo.LoginDetailReportVO;
import com.valuedge.scsc.vo.LoginDetailsVO;
import com.valuedge.scsc.vo.ReportVO;
import com.valuedge.scsc.vo.StatusVo;
import com.valuedge.scsc.vo.UserDetailReportVO;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping(value = "/getLoginDetails")
	@Transactional(readOnly = true)
    public List<LoginDetails> getLoginDetails(LoginDetailsVO loginIdVO) {
        return loginService.getLoginDetails(loginIdVO);
    }

	@PostMapping(value = "/userLogin")
    public ResponseEntity<?> login( @RequestBody LoginDetailsVO loginIdVO) {
		
		String res =loginService.login(loginIdVO);
    	 StatusVo status=new StatusVo();
	    	status.setLoginId(Integer.parseInt(res));
	    	status.setUserId(loginIdVO.getUserId());
	    	return ResponseEntity.ok(status);
    }
    @PutMapping(value = "/saveLogout")
    public ResponseEntity<?> logout(@RequestBody LoginDetailsVO logoutDetails) {
    	String res = loginService.logout(logoutDetails);
    	StatusVo status=new StatusVo();
    	status.setStatus(res);
    	return ResponseEntity.ok(status);
    }
    @GetMapping(value = "/getLoignId")
    public ResponseEntity<?> getLoginId(LoginDetailsVO loginIdVO) {
    	String res = loginService.getLoginId(loginIdVO);
    	StatusVo status=new StatusVo();
    	status.setStatus(res);
    	return ResponseEntity.ok(status);
    }
   
    @PostMapping(value = "/loginReport")
    public ResponseEntity<?> loginReport( @RequestBody ReportVO reportVO) {
	  	   List<LoginDetailReportVO> res = loginService.getLoginRepot(reportVO);
    	  	return ResponseEntity.ok(res);
    }
    
    @PostMapping("/userLoginDetailReport")
    public ResponseEntity<?> userLogindetailReport( @RequestBody ReportVO reportVO) {
       	List<UserDetailReportVO> logdetails = loginService.getLoginDetailRepot(reportVO);
       	return ResponseEntity.ok(logdetails);
    	
    }
    
}
