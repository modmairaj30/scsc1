package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.Date;

public class UserDetailReportVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date loginTime;

	private Date logoutTime;

	private String loginHours;

	private Date loginDate;

	private Double loginLattitude;

	private Double loginLongitude;

	private Double logoutLattitude;

	private Double logoutLongitude;

	public Double getLoginLattitude() {
		return loginLattitude;
	}

	public void setLoginLattitude(Double loginLattitude) {
		this.loginLattitude = loginLattitude;
	}

	public Double getLoginLongitude() {
		return loginLongitude;
	}

	public void setLoginLongitude(Double loginLongitude) {
		this.loginLongitude = loginLongitude;
	}

	public Double getLogoutLattitude() {
		return logoutLattitude;
	}

	public void setLogoutLattitude(Double logoutLattitude) {
		this.logoutLattitude = logoutLattitude;
	}

	public Double getLogoutLongitude() {
		return logoutLongitude;
	}

	public void setLogoutLongitude(Double logoutLongitude) {
		this.logoutLongitude = logoutLongitude;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getLoginHours() {
		return loginHours;
	}

	public void setLoginHours(String loginHours) {
		this.loginHours = loginHours;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
