package com.sony.model.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.OneToMany;

//public class JobPost {
//
//	private int jobPostId;
//	private String jobTitle;
//	private String jobDescription;
//	private boolean isActive;
//	private String experience;
//	private int noOfApplicants;
//	private String postDate;
//	private int noOfVacancies;
//	private String streetAddress;
//	private Company companyentity;
//	private String city;
//	private String state;
//	private LinkedList<JobPostSkill> jobpostskill = new LinkedList<JobPostSkill>();
//
//	public String getStreetAddress() {
//		return streetAddress;
//	}
//
//	public void setStreetAddress(String streetAddress) {
//		this.streetAddress = streetAddress;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public Company getCompanyentity() {
//		return companyentity;
//	}
//
//	public void setCompanyentity(Company companyentity) {
//		this.companyentity = companyentity;
//	}
//
//	public int getJobPostId() {
//		return jobPostId;
//	}
//
//	public void setJobPostId(int jobPostId) {
//		this.jobPostId = jobPostId;
//	}
//
//	public String getJobTitle() {
//		return jobTitle;
//	}
//
//	public void setJobTitle(String jobTitle) {
//		this.jobTitle = jobTitle;
//	}
//
//	public String getJobDescription() {
//		return jobDescription;
//	}
//
//	public void setJobDescription(String jobDescription) {
//		this.jobDescription = jobDescription;
//	}
//
//	public boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public String getExperience() {
//		return experience;
//	}
//
//	public void setExperience(String experience) {
//		this.experience = experience;
//	}
//
//	public int getNoOfApplicants() {
//		return noOfApplicants;
//	}
//
//	public void setNoOfApplicants(int noOfApplicants) {
//		this.noOfApplicants = noOfApplicants;
//	}
//
//	public String getPostDate() {
//		return postDate;
//	}
//
//	public void setPostDate(String postDate) {
//		this.postDate = postDate;
//	}
//
//	public int getNoOfVacancies() {
//		return noOfVacancies;
//	}
//
//	public void setNoOfVacancies(int noOfVacancies) {
//		this.noOfVacancies = noOfVacancies;
//	}
//
//	@OneToMany(mappedBy = "skillset")
//	public LinkedList<JobPostSkill> getJobpostskill() {
//		return jobpostskill;
//	}
//
//	public void setJobpostskill(LinkedList<JobPostSkill> jobpostskill) {
//		this.jobpostskill = jobpostskill;
//	}
//	
//
//=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "job_post")
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_post_sequence")
	@SequenceGenerator(name = "job_post_sequence", sequenceName = "JOB_POST_ID_SEQ")
	@Column(name = "job_post_id")
	private int jobPostId;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "experience")
	private String experience;

	@Column(name = "no_of_applicants")
	private int noOfApplicants;

	@Column(name = "post_date")
	private String postDate;

	@Column(name = "no_of_vacancies")
	private int noOfVacancies;

	@Column(name = "street_address")
	private String streetAddress;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company companyentity;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	private LinkedList<SkillSet> skillset = new LinkedList<SkillSet>();

	public JobPost() {
	}

	public JobPost(int jobPostId, String jobTitle, String jobDescription, boolean isActive, String experience,
			int noOfApplicants, String postDate, int noOfVacancies, String streetAddress, String city, String state,
			Company companyentity) {
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
		this.companyentity = companyentity;
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_GROUPS", joinColumns = @JoinColumn(name = "job_post_id"), 
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	public LinkedList<SkillSet> getSkillset() {
		return skillset;
	}

	public void setSkillset(LinkedList<SkillSet> skillset) {
		this.skillset = skillset;
	}
}
