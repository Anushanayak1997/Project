package com.sony.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyservice;

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@RequestMapping(value = "/getallcompany")
	public List<CompanyDTO> getAllCompany() {
		return companyservice.getAllCompany();
	}

	@RequestMapping(value = "/getcompbyid/{companyId}")
	public Company getUsersById(@PathVariable int companyId) {
		return companyservice.getCompanyById(companyId);
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody CompanyDTO companydto) {
		return (companyservice.addCompany(companydto));
	}

	@RequestMapping(value = "/setcompanyid", method = RequestMethod.POST)
	public Integer setCompanyIdSession(@RequestBody CompanyDTO companydto) {
		return (companyservice.setCompanyIdSession(companydto));
	}
	
// --------------------------------------------Upload File--------------------------------------------------------------//

//	@RequestMapping(value = "/uploadImage/{companyId}", method = RequestMethod.POST)
//	public int handleFileUpload(@PathVariable int companyId, @RequestParam("file") MultipartFile file,
//			HttpSession session) {
//		logger.info("Fileeee" + file.getName() + "Useriddddd" + companyId);
//		return companyservice.store(file, companyId, session);
//	}
//
//	@RequestMapping(value = "/download", produces = "application/pdf")
//	public ResponseEntity<Resource> getFileFromFileSystem(HttpServletResponse response) {
//		// response.setHeader("filename", "1.pdf");
//		// Resource resource = null;
//		// resource = new FileSystemResource("D:/1.pdf");
//		// logger.info("Resource" + resource.getFilename());
//		// return resource;
//		String filename = "1.pdf";
//		Resource file = this.loadFile(filename);
//		logger.info("Filessss" + file);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//				.body(file);
//	}
//
//	private final Path rootLocation = Paths.get("D:/");
//
//	public Resource loadFile(String filename) {
//		try {
//
//			Path file = rootLocation.resolve(filename);
//			logger.info("resolve" + file);
//			Resource resource = new UrlResource(file.toUri());
//			logger.info("resolveURI" + file.toUri());
//			if (resource.exists() || resource.isReadable()) {
//				return resource;
//			} else {
//				throw new RuntimeException("FAIL!");
//			}
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("FAIL!");
//		}
//	}

//	@RequestMapping(value = "/download")
//	public File getFile() {
//		File file = new File("D:/1.pdf");
//		return file;
//	}
}
