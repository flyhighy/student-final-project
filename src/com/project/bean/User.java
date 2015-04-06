package com.project.bean;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String username;
	private String password;
	private String name;
	private String shortdec;
	private Date time;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer type, String username, String password, String name) {
		this.type = type;
		this.username = username;
		this.password = password;
		this.name = name;
	}

	/** full constructor */
	public User(Integer type, String username, String password, String name,
			String shortdec, Date time) {
		this.type = type;
		this.username = username;
		this.password = password;
		this.name = name;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortdec() {
		return this.shortdec;
	}

	public void setShortdec(String shortdec) {
		this.shortdec = shortdec;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}