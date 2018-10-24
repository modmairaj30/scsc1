package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.Date;

public class LoginDetailsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int loginId;

	private String userId;

	private String userName;

	private Date loginTime;

	private Date logoutTime;

	private String loginHours;

	private String password;

	private Date loginDate;
	
	
	private Date logoutDate;
	
	private String sLogoutDate;
	
	
	
	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getsLogoutDate() {
		return sLogoutDate;
	}

	public void setsLogoutDate(String sLogoutDate) {
		this.sLogoutDate = sLogoutDate;
	}

	private String sLoginDate;

	private String loginStatus;

	private String loginLocation;

	private String response;

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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
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

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getLoginLocation() {
		return loginLocation;
	}

	public void setLoginLocation(String loginLocation) {
		this.loginLocation = loginLocation;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getsLoginDate() {
		return sLoginDate;
	}

	public void setsLoginDate(String sLoginDate) {
		this.sLoginDate = sLoginDate;
	}

	@Override
	public String toString() {
		return "LoginDetailsVO [loginId=" + loginId + ", userId=" + userId + ", userName=" + userName + ", loginTime="
				+ loginTime + ", logoutTime=" + logoutTime + ", loginHours=" + loginHours + ", password=" + password
				+ ", loginDate=" + loginDate + ", loginStatus=" + loginStatus + ", loginLocation=" + loginLocation
				+ ", response=" + response + ", loginLattitude=" + loginLattitude + ", loginLongitude=" + loginLongitude
				+ ", logoutLattitude=" + logoutLattitude + ", logoutLongitude=" + logoutLongitude
				+ ", getLoginLattitude()=" + getLoginLattitude() + ", getLoginLongitude()=" + getLoginLongitude()
				+ ", getLogoutLattitude()=" + getLogoutLattitude() + ", getLogoutLongitude()=" + getLogoutLongitude()
				+ ", getResponse()=" + getResponse() + ", getLoginId()=" + getLoginId() + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ", getLoginTime()=" + getLoginTime() + ", getLogoutTime()="
				+ getLogoutTime() + ", getLoginHours()=" + getLoginHours() + ", getLoginStatus()=" + getLoginStatus()
				+ ", getLoginLocation()=" + getLoginLocation() + ", getLoginDate()=" + getLoginDate()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
