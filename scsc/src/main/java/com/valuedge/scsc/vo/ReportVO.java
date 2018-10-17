package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.Date;

public class ReportVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date fromDate;
	private Date toDate;
	private String userId;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
