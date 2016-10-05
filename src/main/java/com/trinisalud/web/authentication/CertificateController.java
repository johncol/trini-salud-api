package com.trinisalud.web.authentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;
import com.trinisalud.service.CertificateService;
import com.trinisalud.web.ApiResponse;;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
	
	private static final Logger LOGGER = Logger.getLogger(CertificateController.class.getName());
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping("")
	public ApiResponse<UploadCertificateResponse> save(@RequestBody UploadCertificateRequest request) {
		LOGGER.info("save request: " + request);
		return new ApiResponse<UploadCertificateResponse>(200, "Ok", certificateService.uploadCertificate(request));
	}
	
	@GetMapping("/{certificateId}")
	public HttpEntity<byte[]> download(HttpServletResponse response, @PathVariable String certificateId) throws IOException {
		LOGGER.info("download request certificateId: " + certificateId);
		byte[] bytes = certificateService.getCertificateBytes(certificateId);
		HttpHeaders headers = buildDownloadCertificateHeaders(bytes);
		return new HttpEntity<byte[]>(bytes, headers);
	}
	
	@GetMapping("")
	public Object get(@RequestParam(name = "patient") String patientId) {
		LOGGER.info("get request patientId: " + patientId);
		return null;
	}

	private HttpHeaders buildDownloadCertificateHeaders(byte[] bytes) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentLength(bytes.length);
		headers.set("Content-Disposition", "attachment; filename=certificado.pdf");
		return headers;
	}

}
