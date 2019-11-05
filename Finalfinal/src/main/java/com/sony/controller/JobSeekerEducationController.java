package com.sony.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobSeekerEducation;

import com.sony.model.service.JobSeekerEducationService;

@RestController
public class JobSeekerEducationController {
	
//	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationController.class);
	
	@Autowired
	JobSeekerEducationService jobseekereducationservice;
	
	@RequestMapping(value = "/getallseekereducation")
	public List<EducationDTO> getAllSeekerEducation() {
		return jobseekereducationservice.getAllSeekerEducation();
	}
	
	@RequestMapping(value = "/addjobseekereducation", method = RequestMethod.POST)
	public Integer addJobSeekerEducation(@RequestBody EducationDTO education) {
		return jobseekereducationservice.addJobSeekerEducation(education);
	}
	
	@RequestMapping(value = "/getseekereducationbyid/{userId}")
	public List<JobSeekerEducation> getSeekerEducationById(@PathVariable int userId) {
		if(jobseekereducationservice.getSeekerEducationById(userId) != null) {
			return jobseekereducationservice.getSeekerEducationById(userId);
		}
		else {
			return null;
		}
	}
	
	@RequestMapping(value = "/editseekereducation", method = RequestMethod.PUT)
	public void editSeekerEducation(@RequestBody JobSeekerEducation jobSeekerEducation) {
		jobseekereducationservice.editseekereducation(jobSeekerEducation);
	}
	
	@RequestMapping(value = "/deleteseekereducation/{educationId}", method = RequestMethod.DELETE)
	public void deleteSeekerEducation(@PathVariable int educationId ) {
		jobseekereducationservice.deleteSeekerEducation(educationId);
	}
}
