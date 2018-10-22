package com.valuedge.scsc.service;

import com.valuedge.scsc.vo.JasperVO;

import net.sf.jasperreports.engine.JasperPrint;

public interface JasperService {
	public JasperPrint exportPdfFile(JasperVO jasperVo);
}
