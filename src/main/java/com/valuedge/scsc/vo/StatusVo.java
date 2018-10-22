package com.valuedge.scsc.vo;

import java.io.Serializable;

public class StatusVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private String message;
	private String code;
	private String userId;
	private int loginId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatus(UserVO res) {
		// TODO Auto-generated method stub

	}
}
