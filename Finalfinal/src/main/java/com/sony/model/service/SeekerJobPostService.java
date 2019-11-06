package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerJobPostDTO;

public interface SeekerJobPostService {
	
	public Integer addSeekerJobPost(SeekerJobPostDTO seekerjobpostdto);

	public void updateSatus(SeekerJobPostDTO seekerJobPostDTO);

	public List<SeekerJobPostDTO> getApplicantsById(int jobpostId);

	public List<SeekerJobPostDTO> getApplicantsByUserId(int userId);
	
	public List<SeekerJobPostDTO> getSelectedUsers(int jobpostId);
}
