package com.sony.model.dto;


public class SeekerSkillDTO {

	private int jobSeekerSkillId;

	private String certificateName;

	private String issuedDate;
	
	private int userId;
	
	private int skillLevel;

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public int getJobSeekerSkillId() {
		return jobSeekerSkillId;
	}

	public void setJobSeekerSkillId(int jobSeekerSkillId) {
		this.jobSeekerSkillId = jobSeekerSkillId;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
