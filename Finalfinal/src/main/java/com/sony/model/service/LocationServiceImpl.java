 package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.LocationDAO;
import com.sony.model.entity.LocationEntity;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationDAO locationdao;
	
	@Autowired
	HttpSession httpsession;

	public List<LocationEntity> getAllLocation() {
	
		return locationdao.getAllLocation();
	}

	public boolean addLocation(LocationEntity location) {
		Integer locationId = locationdao.addLocation(location);
		if(locationId != null) {
			httpsession.setAttribute("locationid", locationId);
			return true;
		}
		return false;
	}

	
}
