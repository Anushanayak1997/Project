package com.sony.model.dto;

import java.io.Serializable;

public class EducationDTO implements Serializable {

	private int jobSeekerEducationId;
	private String startingDate;
	private String endingDate;
	private double marksPercentages;
	private String educationType;
	private String Specialization;
	private int userId;

	public EducationDTO() {
	}

	public int getJobSeekerEducationId() {
		return jobSeekerEducationId;
	}

	public void setJobSeekerEducationId(int jobSeekerEducationId) {
		this.jobSeekerEducationId = jobSeekerEducationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

}
