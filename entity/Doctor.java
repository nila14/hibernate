package org.medex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")

public class Doctor implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 
	 @Column(name = "fname")
	private String fname;
	 @Column(name = "lname")
	private String lname;
	 @Column(name = "pwd")
		private String pwd;
	 @Column(name = "gender")
	private String gender;
	 @Column(name = "age")
	private int age;
	 @Column(name = "qualification")
	private String qualification;
	 @Column(name = "specialization")
	 private String specialization;
	 @Column(name = "contact_no")
	 private String contact_no;
	 @Column(name = "email")
	private String email;
	 @Column(name = "address")
	private String address;
	 @Column(name = "zipcode")
	private int zipcode;
	 @Column(name = "city")
	private String city;

	

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
