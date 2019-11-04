package com.sony.model.dto;

import java.io.Serializable;

public class SeekerSkillDTO implements Serializable{

	private int jobSeekerSkillId;

	private String certificateName;

	private String issuedDate;
	
	private int userID;
	
	private String skillName;
	
	private int skillLevel;

	public SeekerSkillDTO() {
		// TODO Auto-generated constructor stub
	}
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	

	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public SeekerSkillDTO(int jobSeekerSkillId, String certificateName, String issuedDate, int userID, String skillName,
			int skillLevel) {
		super();
		this.jobSeekerSkillId = jobSeekerSkillId;
		this.certificateName = certificateName;
		this.issuedDate = issuedDate;
		this.userID = userID;
		this.skillName=skillName;
		this.skillLevel = skillLevel;
	}

	
}
