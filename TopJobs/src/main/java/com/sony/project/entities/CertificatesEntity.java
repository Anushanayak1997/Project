package com.sony.project.entities;

import java.sql.Date;

public class CertificatesEntity {

	private int certificateID;
	private String certificateName;
	private Date certificateIssueDate;

	public int getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public Date getCertificateIssueDate() {
		return certificateIssueDate;
	}

	public void setCertificateIssueDate(Date certificateIssueDate) {
		this.certificateIssueDate = certificateIssueDate;
	}

}
