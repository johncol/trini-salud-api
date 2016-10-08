package com.trinisalud.model.certificate.search;

public class PatientResponse {

	private String identification;
	private String name;
	private char gender;
	private int age;
	private String birthdate;
	private String address;
	private String phone;
	private String email;
	private String eps;
	private String customerId;

	public PatientResponse() {
	}

	public PatientResponse(String identification, String name, char gender, int age, String birthdate, String address,
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
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
	
	public static class PatientResponseBuilder {
		
		private String identification;
		private String name;
		private char gender;
		private int age;
		private String birthdate;
		private String address;
		private String phone;
		private String email;
		private String eps;
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

		public PatientResponseBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public PatientResponseBuilder setBirthdate(String birthdate) {
			this.birthdate = birthdate;
			return this;
		}

		public PatientResponseBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public PatientResponseBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public PatientResponseBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public PatientResponseBuilder setEps(String eps) {
			this.eps = eps;
			return this;
		}

		public PatientResponseBuilder setCustomerId(String customerId) {
			this.customerId = customerId;
			return this;
		}
		
		public PatientResponse build() {
			return new PatientResponse(identification, name, gender, age, birthdate, address, phone, email, eps, customerId);
		}
		
	}

}
