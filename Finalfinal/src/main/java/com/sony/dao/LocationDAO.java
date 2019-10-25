 package com.sony.dao;

import java.util.List;

import com.sony.model.entity.LocationEntity;

public interface LocationDAO {

	public Integer addLocation(LocationEntity location);

     public	List<LocationEntity> getAllLocation();

	

}
