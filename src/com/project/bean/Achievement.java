package com.project.bean;

import java.util.Date;

/**
 * Achievement entity. @author MyEclipse Persistence Tools
 */

public class Achievement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public Achievement() {
	}

	/** minimal constructor */
	public Achievement(String content) {
		this.content = content;
	}

	/** full constructor */
	public Achievement(String content, Date time) {
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}