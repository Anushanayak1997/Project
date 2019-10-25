package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sony.model.entity.LocationEntity;
import com.sony.model.service.LocationService;

@RestController
public class Location {

	@Autowired
	LocationService locationservice;

	@RequestMapping(value = "/getalllocation")
	public List<LocationEntity> getAllLocation() {
		return locationservice.getAllLocation();
	}

	@RequestMapping(value = "/addlocationdetails", method = RequestMethod.POST)
	public boolean addLocation(@RequestBody LocationEntity location) {
		return (locationservice.addLocation(location));
	}
}
