package com.sony.model.dto;

import java.io.Serializable;

import com.sony.model.entity.User;

public class SeekerProjectDTO implements Serializable{

	private int jobSeekerProjectId;
	private String title;
	private String description;
	private String role;
	private int userId;
	
	private User user;
	
	public SeekerProjectDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SeekerProjectDTO(int jobSeekerProjectId, String title, String description, String role, User user) {

		this.jobSeekerProjectId = jobSeekerProjectId;
		this.title = title;
		this.description = description;
		this.role = role;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getJobSeekerProjectId() {
		return jobSeekerProjectId;
	}
	public void setJobSeekerProjectId(int jobSeekerProjectId) {
		this.jobSeekerProjectId = jobSeekerProjectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
