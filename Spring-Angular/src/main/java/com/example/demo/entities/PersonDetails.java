package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PersonDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int age;

	private String maritalStatus;

	private String email;

	private String area;

	private String district;

	private String block;

	private String city;

	private String gram;

	private long mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Photo photo;

	public PersonDetails() {
		super();
	}

	public PersonDetails(String name, int age, String maritalStatus, String email, String area, String district,
			String block, String city, String gram, long mobileNumber) {
		super();
		this.name = name;
		this.age = age;
		this.maritalStatus = maritalStatus;
		this.email = email;
		this.area = area;
		this.district = district;
		this.block = block;
		this.city = city;
		this.gram = gram;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGram() {
		return gram;
	}

	public void setGram(String gram) {
		this.gram = gram;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", name=" + name + ", age=" + age + ", maritalStatus=" + maritalStatus
				+ ", email=" + email + ", area=" + area + ", district=" + district + ", block=" + block + ", city="
				+ city + ", gram=" + gram + ", mobileNumber=" + mobileNumber + ", photo=" + photo + "]";
	}

}
