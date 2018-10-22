package com.valuedge.scsc.vo;

import java.io.Serializable;
import java.util.Date;

public class SuggestionsVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int suggestionId;
	
	private String userId;
	
	private String suggestion;
	
	private String location;
	
	private Date time;

	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "SuggestionsVO [suggestionId=" + suggestionId + ", userId=" + userId + ", suggestion=" + suggestion
				+ ", location=" + location + ", time=" + time + ", getSuggestionId()=" + getSuggestionId()
				+ ", getUserId()=" + getUserId() + ", getSuggestion()=" + getSuggestion() + ", getLocation()="
				+ getLocation() + ", getTime()=" + getTime() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
