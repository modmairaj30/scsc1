package com.valuedge.scsc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.entities.OTP;

@Service
public class OtpServiceImpl implements OtpService{

	@Value("${smsurl}")
	private String smsurl;
	@Value("${apiKey}")
	private String apikey;
	@Value("${message}")
	private String message;
	@Value("${sender}")
	private String sender;
	@Value("${numbers}")
	private String numbers;
	
	@Value("${apiValue}")
	private String apiValue;
	@Value("${messageValue}")
	private String messageValue;
	@Value("${senderValue}")
	private String senderValue;
	@Value("${numbersValue}")
	private String numbersValue;

	@Override
	public OTP getSms(OTP otp) {
		try {
				String data = smsurl+ apikey+"="+URLEncoder.encode(apiValue,"UTF-8")+"&"+numbers+"="+URLEncoder.encode(numbersValue+otp.getMobileNo(),"UTF-8")+"&"+message+"="+URLEncoder.encode(otp.getOtp()+messageValue,"UTF-8")+"&"+sender+"="+URLEncoder.encode(senderValue,"UTF-8");
				URL url = new URL(data);
				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				
				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				String sResult="";
				while ((line = rd.readLine()) != null) {
				// Process line...
					sResult=sResult+line+" ";
				}
				rd.close();
				otp.setResponse("OTP Sent Succussfully.");
				otp.setMobileNo(otp.getMobileNo());
				otp.setOtp(otp.getOtp());
				return otp;
			} catch (Exception e) {
				e.printStackTrace();
				otp.setResponse("OTP Sent Failed.");
				return otp;
			}
	}
	

}
