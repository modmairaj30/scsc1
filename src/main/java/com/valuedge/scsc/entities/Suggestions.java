package com.valuedge.scsc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "suggestions")
public class Suggestions implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "suggestion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int suggestionId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "suggestion")
	private String suggestion;

	@Column(name = "location", length = 50)
	private String location;

	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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

	@Override
	public String toString() {
		return "Suggestions [suggestionId=" + suggestionId + ", userId=" + userId + ", suggestion=" + suggestion
				+ ", location=" + location + ", time=" + time + ", getUserId()=" + getUserId() + ", getSuggestionId()="
				+ getSuggestionId() + ", getSuggestion()=" + getSuggestion() + ", getLocation()=" + getLocation()
				+ ", getTime()=" + getTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
