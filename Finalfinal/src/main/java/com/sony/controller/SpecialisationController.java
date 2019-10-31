package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.Specialisation;
import com.sony.model.service.SpecialisationService;


@RestController
public class SpecialisationController {
	
	@Autowired
	SpecialisationService specialisationservice;
	
	@RequestMapping(value = "/getallspecialisations")
	public List<Specialisation> getAllSpecialisations() {
		return specialisationservice.getAllSpecialisations();
	}
	
	@RequestMapping(value = "/addspecialisation", method = RequestMethod.POST)
	public boolean addSpecialisation(@RequestBody Specialisation specialisation) {
		return specialisationservice.addSpecialisation(specialisation);
	}

}
