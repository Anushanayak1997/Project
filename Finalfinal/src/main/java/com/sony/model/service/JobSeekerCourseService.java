package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerCourse;



public interface JobSeekerCourseService {
	boolean addJobSeekerCourse(JobSeekerCourse course);

	List<JobSeekerCourse> getAllSeekerCourse();
}
