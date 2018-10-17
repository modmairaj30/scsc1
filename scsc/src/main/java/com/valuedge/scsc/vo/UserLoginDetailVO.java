package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.List;

import com.valuedge.scsc.entities.LoginDetails;

public class UserLoginDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private List<LoginDetails> logindetails;

	public UserLoginDetailVO() {
	}

	public UserLoginDetailVO(String userId, List<LoginDetails> logindetails) {
		this.userId = userId;
		this.logindetails = logindetails;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<LoginDetails> getLogindetails() {
		return logindetails;
	}

	public void setLogindetails(List<LoginDetails> logindetails) {
		this.logindetails = logindetails;
	}

}
