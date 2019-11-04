package com.sony.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobPostDAO;
import com.sony.dao.SeekerJobPostDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.dto.UserDTO;
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
	
	private static final Logger logger = LoggerFactory.getLogger(SeekerJobPostServiceImpl.class);

	public Integer addSeekerJobPost(SeekerJobPostDTO seekerjobpostdto) {
		UserDTO userdto = userdao.getUserById(seekerjobpostdto.getUserId());
		User user = new User(userdto);
		JobPost jobpost = jobpostdao.getJobById(seekerjobpostdto.getJobpostId());
		SeekerJobPostStatus seekerjobpost = new SeekerJobPostStatus(seekerjobpostdto.getStatus(), user, jobpost,
				seekerjobpostdto.getNotificationStatus());
		Integer status = seekerjobpostdao.addSeekerJobPost(seekerjobpost);
		if(status != null) {
			jobpostdao.updateNoApplicants(jobpost.getJobPostId());
		}
		return status;
	}
	
	public void updateSatus(SeekerJobPostDTO seekerjobpostdto) {
		seekerjobpostdao.updateStatus(seekerjobpostdto);
	}

	public List<SeekerJobPostDTO> getApplicantsById(int jobpostId) {
		// logger.info("applicants in serviceeeee" + seekerjobpostdao.getApplicantsById(jobpostId));
		return seekerjobpostdao.getApplicantsById(jobpostId);
	}

	public List<SeekerJobPostDTO> getApplicantsByUserId(int userId) {
		return seekerjobpostdao.getApplicantsByUserId(userId);
	}
	
	public List<SeekerJobPostDTO> getSelectedUsers(int jobpostId) {
		return seekerjobpostdao.getSelectedUsers(jobpostId);
	}
}
