package com.trinisalud.model.certificate.search;

public class PatientResponse {

	private String identification;
	private String name;
	private char gender;
	private String customerId;

	public PatientResponse() {
	}

	public PatientResponse(String identification, String name, char gender, String customerId) {
		super();
		this.identification = identification;
		this.name = name;
		this.gender = gender;
		this.customerId = customerId;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "PatientResponse [identification=" + identification + ", name=" + name + ", gender=" + gender
				+ ", customerId=" + customerId + "]";
	}

	public static class PatientResponseBuilder {

		private String identification;
		private String name;
		private char gender;
		private String customerId;

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

		public PatientResponseBuilder setGender(char gender) {
			this.gender = gender;
			return this;
		}

		public PatientResponseBuilder setCustomerId(String customerId) {
			this.customerId = customerId;
			return this;
		}

		public PatientResponse build() {
			return new PatientResponse(identification, name, gender, customerId);
		}

	}

}
