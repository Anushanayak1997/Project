/**
 * 
 */
package com.sony.project.entities;

import java.sql.Date;

/**
 * @author 7000020632
 *
 */
public class JobPostEntity {

		private int jobPostId;
		private String jobDescription;
		private boolean isActive;
		private int experience;
		private int noOfApplicants;
		private Date postDate;
		private String specialities;
		
		public int getJobPostId() {
			return jobPostId;
		}
		public void setJobPostId(int jobPostId) {
			this.jobPostId = jobPostId;
		}
		public String getJobDescription() {
			return jobDescription;
		}
		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		public int getExperience() {
			return experience;
		}
		public void setExperience(int experience) {
			this.experience = experience;
		}
		public int getNoOfApplicants() {
			return noOfApplicants;
		}
		public void setNoOfApplicants(int noOfApplicants) {
			this.noOfApplicants = noOfApplicants;
		}
		public Date getPostDate() {
			return postDate;
		}
		public void setPostDate(Date postDate) {
			this.postDate = postDate;
		}
		public String getSpecialities() {
			return specialities;
		}
		public void setSpecialities(String specialities) {
			this.specialities = specialities;
		}
		
}
