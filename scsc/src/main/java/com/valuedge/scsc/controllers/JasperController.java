package com.valuedge.scsc.controllers;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.service.*;
import com.valuedge.scsc.vo.*;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping
public class JasperController {

	@Autowired
	private JasperService jasperService;

	@PostMapping(value = "/export")
	public ResponseEntity<byte[]> export(@RequestBody JasperVO jasperVO) throws Exception {

		JasperPrint jasperPrint = null;
		jasperPrint = jasperService.exportPdfFile(jasperVO);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("content-disposition", "inline; filename=" + jasperVO.getOutput() + ".pdf");
		headers.set("Pragma", "no-cache");
		headers.set("Cache-Control", "no-cache");

		outputStream.flush();
		return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

	}

}
