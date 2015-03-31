package com.project.bean;

import java.util.Date;

/**
 * Form entity. @author MyEclipse Persistence Tools
 */

public class Form implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer number;
	private Integer department;
	private String grade;
	private String phone;
	private String email;
	private String inroduction;
	private Date time;

	// Constructors

	/** default constructor */
	public Form() {
	}

	/** minimal constructor */
	public Form(String name, Integer number, Integer department) {
		this.name = name;
		this.number = number;
		this.department = department;
	}

	/** full constructor */
	public Form(String name, Integer number, Integer department, String grade,
			String phone, String email, String inroduction, Date time) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.grade = grade;
		this.phone = phone;
		this.email = email;
		this.inroduction = inroduction;
		this.time = time;
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

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
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

}