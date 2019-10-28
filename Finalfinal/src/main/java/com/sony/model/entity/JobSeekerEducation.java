/**
 * 
 */
package com.sony.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_education")
public class JobSeekerEducation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "job_seeker_education_sequence")
    @SequenceGenerator(name = "job_seeker_education_sequence", sequenceName = "JOB_SEEKER_EDUCATION_ID_SEQ")
	@Column(name = "job_seeker_education_id")
	private int jobSeekerEducationId;
	
	@Column(name="starting_date")
	private String startingDate;
	
	@Column(name="ending_date")
	private String endingDate;
	
	@Column(name="marks_percentages")
	private double marksPercentages;

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
