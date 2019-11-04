package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.SeekerJobPostStatus;

public interface SeekerJobPostDAO {

	public Integer addSeekerJobPost(SeekerJobPostStatus seekerjobpost);
	
	public Integer updateStatus(int userId, int jobpostId);

	public List<SeekerJobPostStatus> getApplicantsById(int jobpostId);

	public List<SeekerJobPostStatus> getApplicantsByUserId(int userId);
}
