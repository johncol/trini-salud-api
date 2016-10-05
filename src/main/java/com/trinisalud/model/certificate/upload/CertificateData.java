package com.trinisalud.model.certificate.upload;

public class CertificateData {
	
	private String name;
	private byte[] file;
	
	public CertificateData() {}

	public CertificateData(String name, byte[] file) {
		super();
		this.name = name;
		this.file = file;
	}
	
	public String getName() {
		return name;
	}
	
	public byte[] getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		return "CertificateData [name=" + name + "]";
	}

}
