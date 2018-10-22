package com.valuedge.scsc.entities;

import java.io.Serializable;

public class OTP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int otp;
	private String mobileNo;
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setContactNo(String contactNo) {
		this.mobileNo = contactNo;
	}

	@Override
	public String toString() {
		return "OTP [otp=" + otp + ", mobileNo=" + mobileNo + ", response=" + response + ", getResponse()="
				+ getResponse() + ", getOtp()=" + getOtp() + ", getMobileNo()=" + getMobileNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
