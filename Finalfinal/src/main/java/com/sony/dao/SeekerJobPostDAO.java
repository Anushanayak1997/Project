package com.sony.dao;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.SeekerJobPostStatus;

public interface SeekerJobPostDAO {

	public Integer addSeekerJobPost(SeekerJobPostStatus seekerjobpost);
	
	public Integer updateStatus(int userId, int jobpostId);
}
