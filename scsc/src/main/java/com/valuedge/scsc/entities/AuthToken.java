package com.valuedge.scsc.entities;

import java.io.Serializable;

public class AuthToken implements Serializable {
	private static final long serialVersionUID = 1L;
	private String token;

	public AuthToken() {

	}

	public AuthToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
