package com.valuedge.scsc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.vo.TrafficVoilationsVO;

public class Utilities {

	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println(fullPath);
		System.out.println(pathArr[0]);
		fullPath = pathArr[0];
		String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
		return reponsePath;
		}
	/*String apiKey = "apikey=" + URLEncoder.encode("VxMcJsfes2E-SiNV9kxuyx4o6zvq4pDaWlfcs0YPQa", "UTF-8");
	String message = "&message=" + URLEncoder.encode(otp.getOtp()+"%20is%20you%20otp.Thank%20you%20for%20registration", "UTF-8");
	String sender = "&sender=" + URLEncoder.encode("CYBSEC", "UTF-8");
	String numbers = "&numbers=" + URLEncoder.encode("91"+otp.getMobileNo(), "UTF-8");*/
	
	// Send data
	//String data = "https://api.textlocal.in/send/?" + apiKey + numbers + message + sender;
	/*@Autowired
	TrafficVoilationRepository tvRepo;
	 File folder = new File("D:\\Voilation_Pics");
	String base64Image = "";
	String imagePath = "D:\\Voilation_Pics\\";
	//String imagePath = ".../scsc/WEB-INF/classes/voilation_images/";
	//String imagePath = "../WEB-INF/classes/voilation_images/";
	@Override
	public TrafficVoilationsVO saveVoilation(TrafficVoilationsVO tvVO) {
		if (!folder.exists()) {
	         if (folder.mkdir()) {
	             System.out.println("Directory is created!");
	         }
	     }else {System.out.println("Directory already exists.");}
		TrafficVoilations tv=new TrafficVoilations();
		tv.setUserId(tvVO.getUserId());
		tv.setLocation(tvVO.getLocation());
		tv.setVoilation(tvVO.getVoilation());
		LocalDateTime now = LocalDateTime.now();
		TrafficVoilationsVO tvVO1= new TrafficVoilationsVO();
    	Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date presentTime = Date.from(instant);
		tv.setTime(presentTime);
		tvRepo.save(tv);
		String voilationId=tvRepo.findByVoilationId(tvVO.getUserId());
		if(voilationId.getPhoto()!=null)  {
		try (FileOutputStream imageOutFile = new FileOutputStream(imagePath+tvVO.getUserId()+"-"+voilationId+".jpg")) {
				byte[] dataBytes = Base64.getEncoder().encode(tvVO.getPhoto());
			    dataBytes = Base64.getDecoder().decode(dataBytes);
				imageOutFile.write(dataBytes);
				
				tvVO1.setStatus("Voilation Saved");
			}
		catch (FileNotFoundException foe) {
			System.out.println("Image Not Found " + foe);
		}catch (Exception ioe) {
				System.out.println("Exception while reading the Image " + ioe);
			}
		}else {
			
			tvVO1.setStatus("No image");
		}
		
		return base64Image;
		byte[] dataBytes = Base64.getEncoder().encode(tvVO.getPhoto());
	    dataBytes = Base64.getDecoder().decode(dataBytes);
		tv.setPhoto(dataBytes);
		
		return tvVO1;
		
	}

	@Override
	public List<TrafficVoilations> getVoilations() {
		return tvRepo.findAll();
	}

	@Override
	public ResponseEntity<?> getVoilationsById(TrafficVoilationsVO tvVO) {
		Optional<TrafficVoilations> tv = tvRepo.findById(tvVO.getVoilationId());
		File file = new File(imagePath+tv.get().getUserId()+"-"+tv.get().getVoilationId()+".jpg");
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			System.out.println("Encoded Successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		tvVO.setLocation(tv.get().getLocation());
		tvVO.setUserId(tv.get().getUserId());
		tvVO.setTime(tv.get().getTime());
		tvVO.setVoilationImage(base64Image);
		
		return ResponseEntity.ok(tvVO);
	}

	@Override
	public ResponseEntity<String> deleteVoilation(TrafficVoilationsVO tvVO) {
		tvRepo.deleteById(tvVO.getVoilationId());
		return ResponseEntity.ok("Voilation Deleted.");
	}*/

	
	/*return base64Image;
	byte[] dataBytes = Base64.getEncoder().encode(tvVO.getPhoto());
    dataBytes = Base64.getDecoder().decode(dataBytes);
	tv.setPhoto(dataBytes);*/
	
	/*@Override
	public ResponseEntity<?> getVoilationsById(TrafficVoilationsVO tvVO) {
		Optional<TrafficVoilations> tv = tvRepo.findById(tvVO.getVoilationId());
		File file = new File(imagePath+tv.get().getUserId()+"-"+tv.get().getVoilationId()+".jpg");
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			System.out.println("Encoded Successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		tvVO.setLocation(tv.get().getLocation());
		tvVO.setUserId(tv.get().getUserId());
		tvVO.setTime(tv.get().getTime());
		tvVO.setVoilationImage(base64Image);
		
		return ResponseEntity.ok(tvVO);
	}*/
}
