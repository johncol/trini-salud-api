package com.trinisalud.web.authentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;
import com.trinisalud.service.CertificateService;
import com.trinisalud.web.ApiResponse;;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping("")
	public ApiResponse<UploadCertificateResponse> save(@RequestBody UploadCertificateRequest request) {
		System.out.println("CertificateController save request: " + request);
		return new ApiResponse<UploadCertificateResponse>(200, "Ok", certificateService.uploadCertificate(request));
	}

}
