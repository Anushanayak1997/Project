package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobSeekerCourse;

import com.sony.model.service.JobSeekerCourseService;

@RestController
public class JobSeekerCourseController {

	@Autowired
	JobSeekerCourseService jobseekercourseservice;
	
	@RequestMapping(value = "/getallseekercourse")
	public List<JobSeekerCourse> getAllSeekerCourse() {
		return jobseekercourseservice.getAllSeekerCourse();
	}
	
	@RequestMapping(value = "/addjobseekercourse", method = RequestMethod.POST)
	public boolean addJobSeekerCourse(@RequestBody JobSeekerCourse course) {
		return jobseekercourseservice.addJobSeekerCourse(course);
	}

}
