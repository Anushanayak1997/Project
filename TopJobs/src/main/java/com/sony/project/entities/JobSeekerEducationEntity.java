/**
 * 
 */
package com.sony.project.entities;

import java.sql.Date;


public class JobSeekerEducationEntity {
	private Date startingDate;
	private Date endingDate;
	private double marksPercentages;

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public double getMarksPercentages() {
		return marksPercentages;
	}

	public void setMarksPercentages(double marksPercentages) {
		this.marksPercentages = marksPercentages;
	}

}
