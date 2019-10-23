package com.sony.model.entity;

import java.util.List;

//import com.sony.project.entities.LocationEntity;

public class JobPostEntity {
	private int jobPostId;
	private String jobTitle;
	private String jobDescription;
	private boolean isActive;
	private String experience;
	private int noOfApplicants;
	private String postDate;
	private int noOfVacancies;
	private List jobPostSkills;
	//private LocationEntity location;
	public int getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	} 
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getNoOfApplicants() {
		return noOfApplicants;
	}
	public void setNoOfApplicants(int noOfApplicants) {
		this.noOfApplicants = noOfApplicants;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getNoOfVacancies() {
		return noOfVacancies;
	}
	public void setNoOfVacancies(int noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}
	public List getJobPostSkills() {
		return jobPostSkills;
	}
	public void setJobPostSkills(List jobPostSkills) {
		this.jobPostSkills = jobPostSkills;
	}
	
}
