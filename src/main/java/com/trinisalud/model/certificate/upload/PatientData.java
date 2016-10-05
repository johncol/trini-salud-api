package com.trinisalud.model.certificate.upload;

public class PatientData {
	
	private String identification;
	private String name;
	private String birthdate;
	private String gender;
	private String eps;
	private String address;
	private String email;
	private String phone;
	
	public PatientData() {}

	public PatientData(String identification, String name, String birthdate, String gender, String eps, String address,
			String email, String phone) {
		super();
		this.identification = identification;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.eps = eps;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PatientData [identification=" + identification + ", name=" + name + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", eps=" + eps + ", address=" + address + ", email=" + email + ", phone="
				+ phone + "]";
	}

}
