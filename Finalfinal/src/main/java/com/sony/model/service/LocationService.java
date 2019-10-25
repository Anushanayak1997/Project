package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.LocationEntity;

public interface LocationService {

	List<LocationEntity> getAllLocation();

	boolean addLocation(LocationEntity location);

}
