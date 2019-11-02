package com.sony.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobPostDAO;
import com.sony.dao.SeekerJobPostDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.User;

@Service
public class SeekerJobPostServiceImpl implements SeekerJobPostService {

	@Autowired
	UserDAO userdao;

	@Autowired
	JobPostDAO jobpostdao;

	@Autowired
	SeekerJobPostDAO seekerjobpostdao;

	public Integer addSeekerJobPost(SeekerJobPostDTO seekerjobpostdto) {
		User user = userdao.getUserById(seekerjobpostdto.getUserId());
		JobPost jobpost = jobpostdao.getJobById(seekerjobpostdto.getJobpostId());
		SeekerJobPostStatus seekerjobpost = new SeekerJobPostStatus(seekerjobpostdto.getStatus(), user, jobpost,
				seekerjobpostdto.getNotificationStatus());
		return seekerjobpostdao.addSeekerJobPost(seekerjobpost);
	}
	
	public Integer updateSatus(SeekerJobPostDTO seekerjobpostdto) {
		return seekerjobpostdao.updateStatus(seekerjobpostdto.getUserId(), seekerjobpostdto.getJobpostId());
	}
}
