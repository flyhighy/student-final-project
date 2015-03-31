package com.project.bean;

/**
 * Download entity. @author MyEclipse Persistence Tools
 */

public class Download implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String name;
	private String path;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** full constructor */
	public Download(Integer type, String name, String path) {
		this.type = type;
		this.name = name;
		this.path = path;
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

}