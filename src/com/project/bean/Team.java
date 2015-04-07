package com.project.bean;

import java.util.Date;

/**
 * Team entity. @author MyEclipse Persistence Tools
 */

public class Team implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Date time;
	private String teacher;
	private String shortdec;

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(String name, String teacher, String shortdec,Date time) {
		this.name = name;
		this.teacher = teacher;
		this.shortdec = shortdec;
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

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getShortdec() {
		return this.shortdec;
	}

	public void setShortdec(String shortdec) {
		this.shortdec = shortdec;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	

}