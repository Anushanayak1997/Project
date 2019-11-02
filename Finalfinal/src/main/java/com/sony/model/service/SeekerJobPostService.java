package com.sony.model.service;

import com.sony.model.dto.SeekerJobPostDTO;

public interface SeekerJobPostService {
	
	public Integer addSeekerJobPost(SeekerJobPostDTO seekerjobpostdto);

	public Integer updateSatus(SeekerJobPostDTO seekerJobPostDTO);
}
