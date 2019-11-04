package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.SeekerJobPostStatus;

public interface SeekerJobPostDAO {

	public Integer addSeekerJobPost(SeekerJobPostStatus seekerjobpost);
	
	public void updateStatus(SeekerJobPostDTO seekerjobpostdto);

	public List<SeekerJobPostDTO> getApplicantsById(int jobpostId);

	public List<SeekerJobPostDTO> getApplicantsByUserId(int userId);
	
	public List<SeekerJobPostDTO> getSelectedUsers(int jobpostId);
}
