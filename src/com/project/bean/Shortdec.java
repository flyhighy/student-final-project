package com.project.bean;

/**
 * Shortdec entity. @author MyEclipse Persistence Tools
 */

public class Shortdec implements java.io.Serializable {

	// Fields

	private Integer id;
	private String shortdec;

	// Constructors

	/** default constructor */
	public Shortdec() {
	}

	/** minimal constructor */
	public Shortdec(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Shortdec(Integer id, String shortdec) {
		this.id = id;
		this.shortdec = shortdec;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortdec() {
		return this.shortdec;
	}

	public void setShortdec(String shortdec) {
		this.shortdec = shortdec;
	}

}