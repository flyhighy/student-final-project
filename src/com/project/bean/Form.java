package com.project.bean;

import java.util.Date;

/**
 * Form entity. @author MyEclipse Persistence Tools
 */

public class Form implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String department;
	private String grade;
	private String phone;
	private String email;
	private String inroduction;
	private Date time;
	private String language;
	private String specialty;
	private String hobby;
	private String experience;
	private String sex;
	private String studentId;

	// Constructors

	/** default constructor */
	public Form() {
	}

	/** full constructor */
	public Form(String name, String department, String grade, String phone,
			String email, String inroduction, Date time, String language,
			String specialty, String hobby, String experience, String sex,
			String studentId) {
		this.name = name;
		this.department = department;
		this.grade = grade;
		this.phone = phone;
		this.email = email;
		this.inroduction = inroduction;
		this.time = time;
		this.language = language;
		this.specialty = specialty;
		this.hobby = hobby;
		this.experience = experience;
		this.sex = sex;
		this.studentId = studentId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInroduction() {
		return this.inroduction;
	}

	public void setInroduction(String inroduction) {
		this.inroduction = inroduction;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}