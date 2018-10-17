package com.valuedge.scsc.vo;

import java.io.Serializable;

public class LoginDetailReportVO implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	private String userId;
	private String userName;
	private String loginHours;
	private String mobileNo;
	private String emailId;
	private String company;
	private String name;
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginHours() {
		return loginHours;
	}

	public void setLoginHours(String loginHours) {
		this.loginHours = loginHours;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
