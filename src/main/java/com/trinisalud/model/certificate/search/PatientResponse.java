package com.trinisalud.model.certificate.search;

public class PatientResponse {

	private String identification;
	private String name;
	private String gender;
	private int age;
	private long birthdate;
	private String address;
	private String phone;
	private String email;
	private String eps;
	private String customerId;

	public PatientResponse() {
	}

	public PatientResponse(String identification, String name, String gender, int age, long birthdate, String address,
			String phone, String email, String eps, String customerId) {
		super();
		this.identification = identification;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthdate = birthdate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.eps = eps;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Patient [identification=" + identification + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", birthdate=" + birthdate + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", eps=" + eps + ", customerId=" + customerId + "]";
	}

}
