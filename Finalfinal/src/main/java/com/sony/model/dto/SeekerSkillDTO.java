package com.sony.model.dto;

import java.io.Serializable;

import com.sony.model.entity.SkillSet;
import com.sony.model.entity.User;

public class SeekerSkillDTO implements Serializable {

	private int jobSeekerSkillId;

	private String certificateName;

	private String issuedDate;
	
	private int userID;
	
	private String skillName;
	private UserDTO user;
	private SkillSetDTO skillset;

	public SeekerSkillDTO() {
		
	}

	public SeekerSkillDTO(int jobSeekerSkillId, String certificateName, String issuedDate, UserDTO user,
			SkillSetDTO skillset) {
		super();
		this.jobSeekerSkillId = jobSeekerSkillId;
		this.certificateName = certificateName;
		this.issuedDate = issuedDate;
		this.user = user;
		this.skillset = skillset;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public SkillSetDTO getSkillset() {
		return skillset;
	}

	public void setSkillset(SkillSetDTO skillset) {
		this.skillset = skillset;
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

}
