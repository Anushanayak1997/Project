package com.sony.model.entity;


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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seeker_skill_sequence")
	@SequenceGenerator(name = "job_seeker_skill_sequence", sequenceName = "JOB_SEEKER_SKILL_ID_SEQ")
	@Column(name = "job_seeker_skill_id")
	private int jobSeekerSkillId;

	@Column(name = "certificate_name")
	private String certificateName;

	@Column(name = "issued_date")
	private String issuedDate;
	
	@Column(name="skill_level")
	private int skillLevel;

	@ManyToOne
	@JoinColumn
	private User user;

	public JobSeekerSkills() {
	}

	
	public JobSeekerSkills(int jobSeekerSkillId, String certificateName, String issuedDate, int skillLevel,User user ) {
		super();
		this.jobSeekerSkillId = jobSeekerSkillId;
		this.certificateName = certificateName;
		this.issuedDate = issuedDate;
		this.skillLevel = skillLevel;
		this.user = user;
		
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
