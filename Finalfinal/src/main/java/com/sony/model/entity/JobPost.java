package com.sony.model.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class JobPost {

	private int jobPostId;
	private String jobTitle;
	private String jobDescription;
	private boolean isActive;
	private String experience;
	private int noOfApplicants;
	private String postDate;
	private int noOfVacancies;
	private String streetAddress;
	private Company companyentity;
	private String city;
	private String state;
	private LinkedList<JobPostSkill> jobpostskill = new LinkedList<JobPostSkill>();

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

	public Company getCompanyentity() {
		return companyentity;
	}

	public void setCompanyentity(Company companyentity) {
		this.companyentity = companyentity;
	}

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

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
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

	@OneToMany(mappedBy = "skillset")
	public LinkedList<JobPostSkill> getJobpostskill() {
		return jobpostskill;
	}

	public void setJobpostskill(LinkedList<JobPostSkill> jobpostskill) {
		this.jobpostskill = jobpostskill;
	}
	

}
