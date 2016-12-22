package com.trinisalud.model.certificate.search;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PatientResponse {

	private String identification;
	private String name;

	public PatientResponse() {
	}

	public PatientResponse(String identification, String name) {
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

	public static class PatientResponseBuilder {

		private String identification;
		private String name;

		public PatientResponseBuilder() {
		}

		public PatientResponseBuilder setIdentification(String identification) {
			this.identification = identification;
			return this;
		}

		public PatientResponseBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public PatientResponse build() {
			return new PatientResponse(identification, name);
		}

	}

}
