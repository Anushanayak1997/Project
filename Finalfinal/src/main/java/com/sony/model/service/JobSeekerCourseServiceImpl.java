package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerCourseDAO;
import com.sony.model.entity.JobSeekerCourse;


@Service
public class JobSeekerCourseServiceImpl implements JobSeekerCourseService {
	
	@Autowired
	JobSeekerCourseDAO jobseekercoursedao;

	public boolean addJobSeekerCourse(JobSeekerCourse course) {
		if (jobseekercoursedao.addJobSeekerCourse(course) != null)
			return true;
		return false;
	}

	public List<JobSeekerCourse> getAllSeekerCourse() {
	return jobseekercoursedao.getAllSeekerCourse();
	}

	
}
