package com.valuedge.scsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.repositories.JasperDaoImp;
import com.valuedge.scsc.vo.JasperVO;

import net.sf.jasperreports.engine.JasperPrint;
@Service
public class JasperServiceImpl implements JasperService{
	
	 @Autowired
	 private JasperDaoImp jasperDao;

	@Override
	public JasperPrint exportPdfFile(JasperVO jasperVo) {
		 return jasperDao.exportPdfFile(jasperVo);
		
	}

}
