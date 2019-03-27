package org.medex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class PatientEntity implements Serializable {
	 private static final long serialVersionUID = -723583058586873479L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "fname")
	String fname;
	 @Column(name = "lname")
	String lname;
	 @Column(name = "pwd")
	String pwd;
	 @Column(name = "age")
	String age;
	 @Column(name = "gender")
	String gender;
	 @Column(name = "email")
	String email;
	 @Column(name = "phn_number")
	String phn_number;
	 @Column(name = "address")
	String address;
	 @Column(name = "zipcode")
	int zipcode;
	 @Column(name = "city")
	String city;

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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhn_number() {
		return phn_number;
	}
	public void setPhn_number(String phn_number) {
		this.phn_number = phn_number;
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
