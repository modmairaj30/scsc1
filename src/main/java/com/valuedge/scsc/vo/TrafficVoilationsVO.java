package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TrafficVoilationsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int voilationId;
	
	private String userId;
	
	private String voilation;
	
	private String location;
	
	private String imgPath;
	
	private Date time;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String voilationImage;
	
    private byte[] photo;
    
    
    
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getVoilationImage() {
		return voilationImage;
	}

	public void setVoilationImage(String voilationImage) {
		this.voilationImage = voilationImage;
	}

	public int getVoilationId() {
		return voilationId;
	}

	public void setVoilationId(int voilationId) {
		this.voilationId = voilationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getVoilation() {
		return voilation;
	}

	public void setVoilation(String voilation) {
		this.voilation = voilation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "TrafficVoilationsVO [voilationId=" + voilationId + ", userId=" + userId + ", voilation=" + voilation
				+ ", location=" + location + ", time=" + time + ", photo=" + Arrays.toString(photo)
				+ ", getVoilationId()=" + getVoilationId() + ", getUserId()=" + getUserId() + ", getVoilation()="
				+ getVoilation() + ", getLocation()=" + getLocation() + ", getTime()=" + getTime() + ", getPhoto()="
				+ Arrays.toString(getPhoto()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

    
     
}
