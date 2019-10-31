package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="job_seeker_course")
public class JobSeekerCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "job_seeker_course_sequence")
    @SequenceGenerator(name = "job_seeker_course_sequence", sequenceName = "JOB_SEEKER_COURSE_ID_SEQ")
	@Column(name = "job_seeker_course_id")
	private int jobSeekerCourseId;
	
	@Column(name="job_seeker_course_name")
	private String jobSeekerCourseName;

	public int getJobSeekerCourseId() {
		return jobSeekerCourseId;
	}

	public void setJobSeekerCourseId(int jobSeekerCourseId) {
		this.jobSeekerCourseId = jobSeekerCourseId;
	}

	public String getJobSeekerCourseName() {
		return jobSeekerCourseName;
	}

	public void setJobSeekerCourseName(String jobSeekerCourseName) {
		this.jobSeekerCourseName = jobSeekerCourseName;
	}
	
	

	
}
