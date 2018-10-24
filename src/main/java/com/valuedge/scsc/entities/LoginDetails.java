package com.valuedge.scsc.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "login_details")

public class LoginDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;

	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "login_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date loginDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "login_time")
	private Date loginTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "logout_date")
	private Date logoutDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "logoutTime")
	private Date logoutTime;

	@Column(name = "login_hours")
	private String loginHours;

	@Column(name = "login_status")
	private String loginStatus;

	@Column(name = "login_location")
	private String loginLocation;

	@Column(name = "login_Lattitude")
	private Double loginLattitude;

	@Column(name = "login_longitude")
	private Double loginLongitude;

	@Column(name = "logout_Lattitude")
	private Double logoutLattitude;

	@Column(name = "logout_longitude")
	private Double logoutLongitude;

	
	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date presentTime) {
		this.loginTime = presentTime;
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

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", userId=" + userId + ", loginDate=" + loginDate + ", loginTime="
				+ loginTime + ", logoutTime=" + logoutTime + ", loginHours=" + loginHours + ", loginStatus="
				+ loginStatus + ", loginLocation=" + loginLocation + ", loginLattitude=" + loginLattitude
				+ ", loginLongitude=" + loginLongitude + ", logoutLattitude=" + logoutLattitude + ", logoutLongitude="
				+ logoutLongitude + ", getLoginLattitude()=" + getLoginLattitude() + ", getLoginLongitude()="
				+ getLoginLongitude() + ", getLogoutLattitude()=" + getLogoutLattitude() + ", getLogoutLongitude()="
				+ getLogoutLongitude() + ", getLoginId()=" + getLoginId() + ", getUserId()=" + getUserId()
				+ ", getLoginTime()=" + getLoginTime() + ", getLogoutTime()=" + getLogoutTime() + ", getLoginHours()="
				+ getLoginHours() + ", getLoginStatus()=" + getLoginStatus() + ", getLoginLocation()="
				+ getLoginLocation() + ", getLoginDate()=" + getLoginDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
