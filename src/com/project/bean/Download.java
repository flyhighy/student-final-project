package com.project.bean;

import java.util.Date;

/**
 * Download entity. @author MyEclipse Persistence Tools
 */

public class Download implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String name;
	private String path;
	private Date time;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** full constructor */
	public Download(Integer type, String name, String path,Date time) {
		this.type = type;
		this.name = name;
		this.path = path;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	

}