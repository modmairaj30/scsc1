package com.valuedge.scsc.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuedge.scsc.vo.JasperVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@Repository
public class JasperDaoImp implements JasperDao{

	@Autowired
	DataSource dataSource;
	@Autowired
	 private ResourceLoader resourceLoader;
	
	@Override
	public JasperPrint exportPdfFile(JasperVO jasperVo) {
		Connection conn=null;
		JasperPrint print =null;
		try {
		 conn = dataSource.getConnection();

		  String path = resourceLoader.getResource("classpath:"+jasperVo.getReportName()+".jrxml").getURI().getPath();
		  
		  
		  JasperReport jasperReport = JasperCompileManager.compileReport(path);

		  // Parameters for report
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  parameters.put("parameter1", jasperVo.getParam());
		   print = JasperFillManager.fillReport(jasperReport, parameters, conn);
			/*JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here
			System.out.println(reportName + ".pdf");
			exporter.exportReport();*/
		}catch(SQLException| JRException| IOException ex) {
			ex.printStackTrace();
		}

		  return print;
	}

}
