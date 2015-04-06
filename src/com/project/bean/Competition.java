package com.project.bean;

import java.util.Date;

/**
 * Competition entity. @author MyEclipse Persistence Tools
 */

public class Competition implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String content;
	private String author;
	private Date time;

	// Constructors

	/** default constructor */
	public Competition() {
	}

	/** minimal constructor */
	public Competition(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Competition(Integer id, String name, String content, String author,
			Date time) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.author = author;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}