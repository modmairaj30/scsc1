package com.valuedge.scsc.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.repositories.TrafficVoilationRepository;
import com.valuedge.scsc.vo.TrafficVoilationsVO;

@Service
public class TVServiceImpl implements TVService{
	
	
	@Autowired
	TrafficVoilationRepository tvRepo;
	String base64Image = "";
	String imagePath = this.getClass().getClassLoader().getResource("").getPath();
	String fullPath;
	@Override
	public String saveVoilation(TrafficVoilationsVO tvVO) {
		
		try {
			fullPath = URLDecoder.decode(imagePath, "UTF-8");
			String pathArr[] = fullPath.split("/WEB-INF/classes/");
			fullPath = pathArr[0];
			File folder = new File(fullPath+"/violation_images");
			if (!folder.exists()) {
		         if (folder.mkdir()) {
		             
		         }
		     }else {System.out.println("Directory already exists.");}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		TrafficVoilations tv=new TrafficVoilations();
		tv.setUserId(tvVO.getUserId());
		tv.setLocation(tvVO.getLocation());
		tv.setVoilation(tvVO.getVoilation());
		LocalDateTime now = LocalDateTime.now();
    	Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date presentTime = Date.from(instant);
		tv.setTime(presentTime);
		TrafficVoilations voilationId= tvRepo.save(tv);
        if(tvVO.getPhoto()!=null) {	
		try (FileOutputStream imageOutFile = new FileOutputStream(fullPath+"/violation_images/"+voilationId.getUserId()+"-"+voilationId.getVoilationId()+".jpg")) {
				byte[] dataBytes = Base64.getEncoder().encode(tvVO.getPhoto());
			    dataBytes = Base64.getDecoder().decode(dataBytes);
				imageOutFile.write(dataBytes);
				System.out.println("Image Saved");
			} catch (FileNotFoundException e) {
				System.out.println("Image not found" + e);
			} catch (IOException ioe) {
				System.out.println("Exception while reading the Image " + ioe);
			}
        }
		return "save";
	}

	@Override
	public List<TrafficVoilations> getVoilations() {
		return tvRepo.findAll();
	}


	@Override
	public String deleteVoilation(TrafficVoilationsVO tvVO) {
		tvRepo.deleteById(tvVO.getVoilationId());
		return "Deleted";
	}
}
