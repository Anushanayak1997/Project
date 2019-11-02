package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.service.SeekerJobPostService;


@RestController
public class SeekerJobPostController {
	
	@Autowired
	SeekerJobPostService seekerjobpostservice;
	
	@RequestMapping(value = "/applyjobpost", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody SeekerJobPostDTO seekerjobpostdto) {
		return(seekerjobpostservice.addSeekerJobPost(seekerjobpostdto));
	}
}
