package com.valuedge.scsc.vo;

import java.io.Serializable;

public class JasperVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int reportId;
	private String reportName;
	private String output;
	private String param;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
