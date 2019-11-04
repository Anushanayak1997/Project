/**
 * 
 */
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
@Table(name = "job_seeker_education")
public class JobSeekerEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seeker_education_sequence")
	@SequenceGenerator(name = "job_seeker_education_sequence", sequenceName = "JOB_SEEKER_EDUCATION_ID_SEQ")
	@Column(name = "job_seeker_education_id")
	private int jobSeekerEducationId;

	@Column(name = "starting_date")
	private String startingDate;

	@Column(name = "ending_date")
	private String endingDate;

	@Column(name = "marks_percentages")
	private double marksPercentages;

	@Column(name = "education_type")
	private String educationType;
	
	@Column(name = "specializaition")
	private String specialization;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public JobSeekerEducation() {
	}

	public JobSeekerEducation(int jobSeekerEducationId, String startingDate, String endingDate, double marksPercentages,
			String educationType, String specialization, User user) {
		super();
		this.jobSeekerEducationId = jobSeekerEducationId;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.marksPercentages = marksPercentages;
		this.educationType = educationType;
		this.specialization = specialization;
		this.user = user;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}

	public double getMarksPercentages() {
		return marksPercentages;
	}

	public void setMarksPercentages(double marksPercentages) {
		this.marksPercentages = marksPercentages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getJobSeekerEducationId() {
		return jobSeekerEducationId;
	}

	public void setJobSeekerEducationId(int jobSeekerEducationId) {
		this.jobSeekerEducationId = jobSeekerEducationId;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
