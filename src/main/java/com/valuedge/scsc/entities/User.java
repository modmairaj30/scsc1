package com.valuedge.scsc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE LOWER(u.userName) = LOWER(?1)")
@Table(name = "user_details")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id

	@GenericGenerator(name = "userId", strategy = "com.valuedge.scsc.generators.UserIdGenerator")
	@GeneratedValue(generator = "userId")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_name", length = 50, unique = true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "mobile_no", length = 50)
	private String mobileNo;

	@Column(name = "email_id", length = 50)
	private String emailId;

	@Column(name = "company", length = 50)
	private String company;

	// private Set<LoginDetails> loginDetails;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", getUserId()=" + getUserId()
				+ ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getName()=" + getName()
				+ ", getMobileNo()=" + getMobileNo() + ", getEmailId()=" + getEmailId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/*
	 * public String getCompany() { return company; }
	 * 
	 * public void setCompany(String company) { this.company = company; }
	 */

	/*
	 * @OneToMany(targetEntity=LoginDetails.class,fetch=FetchType.EAGER,cascade=
	 * CascadeType.ALL)
	 * 
	 * @JoinColumn(name="userId",referencedColumnName="userId") public
	 * Set<LoginDetails> getLoginDetails() { return loginDetails; }
	 * 
	 * public void setLoginDetails(Set<LoginDetails> loginDetails) {
	 * this.loginDetails = loginDetails;
	 */

}

/*
 * @OneToMany(cascade = { CascadeType.ALL,CascadeType.PERSIST},
 * fetch=FetchType.LAZY)
 * 
 * @JoinColumn(name="user_id", referencedColumnName="user_id")
 * 
 * @ManyToMany(cascade=CascadeType.ALL,mappedBy="user_details") private
 * Set<LoginDetails> login;
 * 
 * @OneToMany(cascade = { CascadeType.ALL,CascadeType.PERSIST},
 * fetch=FetchType.LAZY)
 * 
 * @JoinColumn(name="user_id", referencedColumnName="user_id")
 * 
 * @ManyToMany(cascade=CascadeType.ALL,mappedBy="user_details") private
 * Set<Suggestions> sugg;
 * 
 * @OneToMany(cascade = {
 * CascadeType.ALL,CascadeType.PERSIST},fetch=FetchType.LAZY)
 * 
 * @JoinColumn(name="user_id", referencedColumnName="user_id")
 * 
 * @ManyToMany(cascade=CascadeType.ALL,mappedBy="user_details") private
 * Set<TrafficVoilations> tv;
 */
