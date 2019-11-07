package com.sony.model.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sony.dao.CompanyDAO;
import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.EmployerCompany;
import com.sony.model.entity.Avatar;

@Service

public class CompanyServiceImpl implements CompanyService {
	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	CompanyDAO companydao;

	@Autowired
	HttpSession httpsession;

	@Autowired
	EmployerCompanyService employerservice;

	public List<CompanyDTO> getAllCompany() {
		return companydao.getAllCompany();
	}

	public Integer addCompany(CompanyDTO companydto) {
		logger.info("Userid in emp_cmp" + companydto.getCompimage());
		byte[] imageByte = Base64.getDecoder().decode(companydto.getCompimage());
		Company company = new Company(companydto.getCompanyId(), companydto.getCompanyName(),
				companydto.getCompanyDescription(), companydto.getEstablishmentDate(), companydto.getWebsiteUrl(),
				companydto.getHeadquarter(), companydto.getSpecialities(), companydto.getIndustry(),
				companydto.getType(), imageByte);
		Integer companyId = companydao.addCompany(company);
		if (companyId != null) {
			EmployerCompany employercompanyentity = new EmployerCompany(companydto.getUserId(), companyId);
			employerservice.addEmployerCompany(employercompanyentity);
			return companyId;
		}
		return null;
	}

	public Integer setCompanyIdSession(CompanyDTO companydto) {
		Integer companyid = companydto.getCompanyId();
		if (companyid != null) {
			logger.info("User id" + companydto.getUserId());
			EmployerCompany employercompanyentity = new EmployerCompany(companydto.getUserId(),
					companydto.getCompanyId());
			employerservice.addEmployerCompany(employercompanyentity);
		}
		return companyid;
	}

	public CompanyDTO getCompanyById(int companyId) {
		return companydao.getCompanyById(companyId);
	}

	public Integer addImage(byte[] file) {
		return companydao.addImage(file);
	}

	public String getImage(int avatarId) {
		return companydao.getImage(avatarId);
	}
	
//	public int store(MultipartFile file, int userId, HttpSession session) {
//
//		// Path rootLocation = Paths.get(session.getServletContext().getRealPath("/resources/images"));
//		Path rootLocation = Paths.get("D:/");
//		System.out.println("rootLocation  ==  " + rootLocation);
////		UserDetail user = companydao.getUserById(userId);
//		String nameExtension[] = file.getContentType().split("/");
//		String profileImage = userId + "." + nameExtension[1];
//		System.out.println("ProfileImage  :: " + profileImage);
//		int status = 1;
//		if (status == 1) {
////			if (user.getProfileImage() == null || user.getProfileImage() == " "
////					|| user.getProfileImage() == "") {
//			int result = companydao.updateProfileImage(profileImage, 1);
//				try {
//					Files.copy(file.getInputStream(), rootLocation.resolve(profileImage));
//					// int result = companydao.updateProfileImage(profileImage, 1);
//					if (result > 0)
//						return result;
//					else
//						return -5;
//				} catch (Exception exception) {
//					System.out.println("error while uploading image catch:: " + exception.getMessage());
//					return -5;
//				}
//			} else {
//				try {
//					// Files.delete(rootLocation.resolve(profileImage));
//					// Files.delete(rootLocation.resolve(user.getProfileImage()));
//					Files.copy(file.getInputStream(), rootLocation.resolve(profileImage));
//					int result = companydao.updateProfileImage(profileImage, 1);
//					if (result > 0)
//						return result;
//					else
//						return -5;
//				} catch (Exception exception) {
//					System.out.println(
//							"Error while uploading image when image is already Exists :: " + exception.getMessage());
//					return -5;
//				}
//			}
//	}
}
