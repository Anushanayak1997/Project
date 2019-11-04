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
@Table(name = "seeker_jobpost_status")
public class SeekerJobPostStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seeker_jobpost_sequence")
	@SequenceGenerator(name = "seeker_jobpost_sequence", sequenceName = "SEEKER_JOBPOST_ID_SEQ")
	@Column(name = "seeker_jobpost_id")
	private int id;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_post_id")
	private JobPost jobpost;

	@Column(name = "notification_status")
	private int notificationStatus;

	public SeekerJobPostStatus() {
	}
	
	public SeekerJobPostStatus(String status, User user, JobPost jobpost, int notificationStatus) {
		this.status = status;
		this.user = user;
		this.jobpost = jobpost;
		this.notificationStatus = notificationStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobPost getJobpost() {
		return jobpost;
	}

	public void setJobpost(JobPost jobpost) {
		this.jobpost = jobpost;
	}

	public int getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(int notificationStatus) {
		this.notificationStatus = notificationStatus;
	}
	
	@Override
	public String toString() {
		return this.status + " " + this.user.getEmailID() + " " + this.user.getPassword() + this.user.getFirstName() + this.user.getLastName() + this.jobpost.getJobDescription()
		+ this.jobpost.getJobTitle() + this.jobpost.getCity() + this.jobpost.getExperience() + this.jobpost.getNoOfApplicants() + this.jobpost.getNoOfVacancies() + this.jobpost.getStreetAddress();
	}

}
