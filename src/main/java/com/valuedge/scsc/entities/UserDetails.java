package com.valuedge.scsc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE LOWER(u.userName) = LOWER(?1)")
@Table(name = "view_get_login_details")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_name", length = 50, unique = true)
	private String userName;

	@Column(name = "login_hours")
	private String loginHours;

	@Column(name = "mobile_no", length = 50)
	private String mobileNo;

	@Column(name = "email_id", length = 50)
	private String emailId;

	@Column(name = "company", length = 50)
	private String company;

	@Column(name = "name")
	private String name;
	
	@Column(name = "total")
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "login_date")
	private Date loginDate;

	public String getUserId() {
		return userId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
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

	public String getLoginHours() {
		return loginHours;
	}

	public void setLoginHours(String loginHours) {
		this.loginHours = loginHours;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", name=" + ", mobileNo=" + mobileNo + ", emailId="
				+ emailId + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName() + ",  getName()="
				+ ", getMobileNo()=" + getMobileNo() + ", getEmailId()=" + getEmailId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
