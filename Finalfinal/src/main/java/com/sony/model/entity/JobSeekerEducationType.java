package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "job_seeker_education_type")
public class JobSeekerEducationType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seeker_education_sequence")
	@SequenceGenerator(name = "job_seeker_education_sequence", sequenceName = "JOB_SEEKER_EDUCATION_ID_SEQ")
	@Column(name = "job_seeker_education_id")
	private int jobSeekerEducationId;

	@Column(name = "job_seeker_education_name")
	private String JobSeekerEducationName;

	public int getJobSeekerEducationId() {
		return jobSeekerEducationId;
	}

	public void setJobSeekerEducationId(int jobSeekerEducationId) {
		this.jobSeekerEducationId = jobSeekerEducationId;
	}

	public String getJobSeekerEducationName() {
		return JobSeekerEducationName;
	}

	public void setJobSeekerEducationName(String jobSeekerEducationName) {
		JobSeekerEducationName = jobSeekerEducationName;
	}

}
