package com.sony.model.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sony.model.entity.Company;
import com.sony.model.entity.SkillSet;

public class JobPostDTO implements Serializable {

	private int companyId;
	private int jobPostId;
	private String jobTitle;
	private String jobDescription;
	private String isActive;
	private int experience;
	private int noOfApplicants;
	private String postDate;
	private int noOfVacancies;
	private String streetAddress;
	private String city;
	private String state;
	private Set<SkillSetDTO> skillset;
	private Company company;

	public JobPostDTO() {
		// TODO Auto-generated constructor stub
	}

	public JobPostDTO(int jobPostId, String jobTitle, String jobDescription, String isActive, int experience,
			int noOfApplicants, String postDate, int noOfVacancies, String streetAddress, String city, String state) {
		this.jobPostId = jobPostId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.isActive = isActive;
		this.experience = experience;
		this.noOfApplicants = noOfApplicants;
		this.postDate = postDate;
		this.noOfVacancies = noOfVacancies;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
	}

	public JobPostDTO(int jobPostId, String jobTitle, String jobDescription, String isActive, int experience,
			int noOfApplicants, String postDate, int noOfVacancies, String streetAddress, String city, String state,
			Set<SkillSetDTO> skillset, Company company) {
		this.jobPostId = jobPostId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.isActive = isActive;
		this.experience = experience;
		this.noOfApplicants = noOfApplicants;
		this.postDate = postDate;
		this.noOfVacancies = noOfVacancies;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.skillset = skillset;
		this.company = company;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
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

	public Set<SkillSetDTO> getSkillset() {
		return skillset;
	}

	public void setSkillset(Set<SkillSetDTO> skillset) {
		this.skillset = skillset;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
