/**
 * 
 */
package com.sony.project.entities;

import java.sql.Date;

/**
 * @author 7000020632
 *
 */
public class JobPostEntity {

	private int jobPostId;
	private String jobTitle;
	private String jobDescription;
	private boolean isActive;
	private String experience;
	private int noOfApplicants;
	private String postDate;
	private String specialities;
	private int noOfVacancies;

	public JobPostEntity(int jobPostId, String jobTitle, String jobDescription, boolean isActive, String experience,
			int noOfApplicants, String postDate, String specialities, int noOfVacancies) {
		this.jobPostId = jobPostId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.isActive = isActive;
		this.experience = experience;
		this.noOfApplicants = noOfApplicants;
		this.postDate = postDate;
		this.specialities = specialities;
		this.noOfVacancies = noOfVacancies;
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

	public int getNoOfVacancies() {
		return noOfVacancies;
	}

	public void setNoOfVacancies(int noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
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

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

}
