package com.sony.model.dto;

import java.io.Serializable;

public class SeekerJobPostDTO implements Serializable {

	private int userId;
	private int jobpostId;
	private String status;
	private int notificationStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJobpostId() {
		return jobpostId;
	}

	public void setJobpostId(int jobpostId) {
		this.jobpostId = jobpostId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(int notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

}
