package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.User;

public interface SeekerJobPostService {
	
	public Integer addSeekerJobPost(SeekerJobPostDTO seekerjobpostdto);

	public Integer updateSatus(SeekerJobPostDTO seekerJobPostDTO);

	public List<SeekerJobPostStatus> getApplicantsById(int jobpostId);

	public List<SeekerJobPostStatus> getApplicantsByUserId(int userId);
}
