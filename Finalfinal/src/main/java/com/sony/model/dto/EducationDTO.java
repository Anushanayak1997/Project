package com.sony.model.dto;

import javax.persistence.Column;

public class EducationDTO {

	private int jobSeekerEducationId;
	private String startingDate; 
	private String endingDate;
	private double marksPercentages;
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

}
