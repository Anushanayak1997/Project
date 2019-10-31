package com.sony.model.dto;

public class SeekerProjectDTO {

	private int jobSeekerProjectId;
	private String title;
	private String description;
	private String role;
	private int userId;
	
	public SeekerProjectDTO() {
		
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
