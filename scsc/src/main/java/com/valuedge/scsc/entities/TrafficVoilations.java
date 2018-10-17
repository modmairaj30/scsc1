package com.valuedge.scsc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "traffic_voilation")
public class TrafficVoilations implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "voilation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voilationId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "voilation")
	private String voilation;

	@Column(name = "location", length = 50)
	private String location;

	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "img_path")
	private String imgPath;

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getVoilation() {
		return voilation;
	}

	public void setVoilation(String voilation) {
		this.voilation = voilation;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVoilationId() {
		return voilationId;
	}

	public void setVoilationId(int voilationId) {
		this.voilationId = voilationId;
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

}
