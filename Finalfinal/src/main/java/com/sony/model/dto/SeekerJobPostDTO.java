package com.sony.model.dto;

import java.io.Serializable;

import com.sony.model.entity.JobPost;
import com.sony.model.entity.User;

public class SeekerJobPostDTO implements Serializable {

	private int userId;
	private int jobpostId;
	private int Id;
	private String status;
	private int notificationStatus;
	private UserDTO user;
	private JobPostDTO jobpost;

	public SeekerJobPostDTO() {
	}

	public SeekerJobPostDTO(int Id, String status, int notificationStatus, UserDTO user, JobPostDTO jobpost) {
		this.Id = Id;
		this.status = status;
		this.notificationStatus = notificationStatus;
		this.user = user;
		this.jobpost = jobpost;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public JobPostDTO getJobpost() {
		return jobpost;
	}

	public void setJobpost(JobPostDTO jobpost) {
		this.jobpost = jobpost;
	}
	
	

}
