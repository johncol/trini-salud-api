package com.trinisalud.model.certificate.upload;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PatientData {

	private String identification;
	private String name;

	public PatientData() {
	}

	public PatientData(String identification, String name, char gender) {
		super();
		this.identification = identification;
		this.name = name;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
