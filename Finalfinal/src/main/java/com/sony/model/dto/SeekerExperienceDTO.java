package com.sony.model.dto;

import java.io.Serializable;

public class SeekerExperienceDTO implements Serializable{

	private int JobSeekerExperienceId;
	private String jobTitle;

	private String startDate;

	private String endDate;

	private String jobDescription;

	private String streetAddress;

	private String city;

	private String state;
	private int userId;
	
	public SeekerExperienceDTO() {
	
	}
	public int getJobSeekerExperienceId() {
		return JobSeekerExperienceId;
	}
	public void setJobSeekerExperienceId(int jobSeekerExperienceId) {
		JobSeekerExperienceId = jobSeekerExperienceId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
