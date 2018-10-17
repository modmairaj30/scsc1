package com.valuedge.scsc.repositories;

import com.valuedge.scsc.vo.JasperVO;

import net.sf.jasperreports.engine.JasperPrint;

public interface JasperDao {
	public JasperPrint exportPdfFile(JasperVO jasperVo);
}
