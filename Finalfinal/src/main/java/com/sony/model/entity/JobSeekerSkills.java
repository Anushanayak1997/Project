package com.sony.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "job_seeker_skills")
public class JobSeekerSkills {

	// JobSeekerSkills jobSeeker=new JobSeekerSkills();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seeker_skill_sequence")
	@SequenceGenerator(name = "job_seeker_skill_sequence", sequenceName = "JOB_SEEKER_SKILL_ID_SEQ")
	@Column(name = "job_seeker_skill_id")
	private int jobSeekerSkillId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	private SkillSet skillset;

	@Column(name = "certificate_name")
	private String certificateName;

	@Column(name = "issued_date")
	private String issuedDate;

	@Column(name = "skill_level")
	private int skillLevel;

	public JobSeekerSkills() {
	}

	public JobSeekerSkills(int jobSeekerSkillId, String certificateName, String issuedDate, User user,
			SkillSet skillset) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SkillSet getSkillset() {
		return skillset;
	}

	public void setSkillset(SkillSet skillset) {
		this.skillset = skillset;
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

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

}
