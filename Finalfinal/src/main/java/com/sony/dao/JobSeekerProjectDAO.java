package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SeekerProjectDTO;
import com.sony.model.entity.JobSeekerProject;

public interface JobSeekerProjectDAO {
	Integer addJobSeekerProject(JobSeekerProject project);

	List<SeekerProjectDTO> getAllProject();

	List<SeekerProjectDTO> getProjectsById(int userId);

	void editSeekerProject(JobSeekerProject jobSeekerproject);

	void deleteSeekerProject(int projectId);

}
