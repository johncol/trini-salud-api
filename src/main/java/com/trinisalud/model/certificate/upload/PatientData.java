package com.trinisalud.model.certificate.upload;

public class PatientData {

	private String identification;
	private String name;
	private char gender;

	public PatientData() {
	}

	public PatientData(String identification, String name, char gender) {
		super();
		this.identification = identification;
		this.name = name;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "PatientData [identification=" + identification + ", name=" + name + ", gender=" + gender + "]";
	}

}
