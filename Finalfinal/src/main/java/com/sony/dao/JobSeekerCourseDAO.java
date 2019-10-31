package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerCourse;


public interface JobSeekerCourseDAO {

	Integer addJobSeekerCourse(JobSeekerCourse course);

	List<JobSeekerCourse> getAllSeekerCourse();
}
