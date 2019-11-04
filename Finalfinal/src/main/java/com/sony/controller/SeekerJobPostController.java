package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.User;
import com.sony.model.service.SeekerJobPostService;


@RestController
public class SeekerJobPostController {
	
	@Autowired
	SeekerJobPostService seekerjobpostservice;
	
	@RequestMapping(value = "/applyjobpost", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody SeekerJobPostDTO seekerjobpostdto) {
		return(seekerjobpostservice.addSeekerJobPost(seekerjobpostdto));
	}
	
	@RequestMapping(value = "/getapplicantsbyid/{jobpostId}")
	public List<SeekerJobPostStatus> getApplicantsById(@PathVariable int jobpostId) {
		return seekerjobpostservice.getApplicantsById(jobpostId);
	}
	
	@RequestMapping(value = "/getapplicantsbyuserid/{userId}")
	public List<SeekerJobPostStatus> getApplicantsByUserId(@PathVariable int userId) {
		return seekerjobpostservice.getApplicantsByUserId(userId);
	}
}
