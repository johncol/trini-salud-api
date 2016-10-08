package com.trinisalud.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

import com.trinisalud.model.certificate.search.SearchCertificateResponse;
import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;
import com.trinisalud.service.CertificateService;
import com.trinisalud.service.ServiceException;
import com.trinisalud.service.UploadCertificateService;;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

	private static final Logger LOGGER = Logger.getLogger(CertificateController.class.getName());

	@Autowired
	private UploadCertificateService uploadCertificateService;

	@Autowired
	private CertificateService certificateService;

	@PostMapping("")
	public ApiResponse<UploadCertificateResponse> save(@RequestBody UploadCertificateRequest request) {
		LOGGER.info("save request: " + request);
		try {
			UploadCertificateResponse response = uploadCertificateService.upload(request);
			return new ApiResponse<UploadCertificateResponse>(true, "Ok", response);
		} catch (ServiceException e) {
			return new ApiResponse<UploadCertificateResponse>(false, e.getMessage());
		}
	}

	@GetMapping("")
	public ApiResponse<SearchCertificateResponse> get(@RequestParam(name = "patient") String patientId) {
		LOGGER.info("get request patientId: " + patientId);
		try {
			SearchCertificateResponse response = certificateService.search(patientId);
			return new ApiResponse<SearchCertificateResponse>(true, "ok", response);
		} catch (ServiceException e) {
			return new ApiResponse<SearchCertificateResponse>(false, e.getMessage());
		}
	}

	@GetMapping("/{certificateId}")
	public HttpEntity<byte[]> download(HttpServletResponse response, @PathVariable String certificateId)
			throws IOException {
		LOGGER.info("download request certificateId: " + certificateId);
		byte[] bytes = certificateService.getCertificateBytes(certificateId);
		HttpHeaders headers = buildDownloadCertificateHeaders(bytes);
		return new HttpEntity<byte[]>(bytes, headers);
	}

	private HttpHeaders buildDownloadCertificateHeaders(byte[] bytes) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentLength(bytes.length);
		headers.set("Content-Disposition", "attachment; filename=certificado.pdf");
		return headers;
	}

}
