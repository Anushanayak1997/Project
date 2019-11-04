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
@Table(name="job_seeker_experience")
public class JobSeekerExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "job_seeker_experience_sequence")
    @SequenceGenerator(name = "job_seeker_experience_sequence", sequenceName = "JOB_SEEKER_EXPERIENCE_ID_SEQ")
	@Column(name = "job_seeker_experience_id")
	private int jobSeekerExperienceId;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;

	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	public String getStreetAddress() {
		return streetAddress;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public JobSeekerExperience() {
	}
	

	public JobSeekerExperience(int jobSeekerExperienceId, String jobTitle, String startDate, String endDate,
			String jobDescription, String streetAddress, String city, String state, User user) {
		super();
		this.jobSeekerExperienceId = jobSeekerExperienceId;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobDescription = jobDescription;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.user = user;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	public String getStartDate() {
		return startDate; 
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public int getJobSeekerExperienceId() {
		return jobSeekerExperienceId;
	}


	public void setJobSeekerExperienceId(int jobSeekerExperienceId) {
		this.jobSeekerExperienceId = jobSeekerExperienceId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
