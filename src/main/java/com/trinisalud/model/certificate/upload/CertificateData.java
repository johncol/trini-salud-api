package com.trinisalud.model.certificate.upload;

public class CertificateData {
	
	private String name;
	private String file;
	
	public CertificateData() {}

	public CertificateData(String name, String file) {
		super();
		this.name = name;
		this.file = file;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFile() {
		return file;
	}

	@Override
	public String toString() {
		return "CertificateData [name=" + name + ", file=" + file + "]";
	}

}
