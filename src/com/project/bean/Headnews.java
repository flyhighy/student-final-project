package com.project.bean;

import java.util.Date;

/**
 * Headnews entity. @author MyEclipse Persistence Tools
 */

public class Headnews implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String image;
	private String content;
	private String author;
	private Date time;
	private String source;

	// Constructors

	/** default constructor */
	public Headnews() {
	}

	/** full constructor */
	public Headnews(String title, String image, String conent, String author,
			Date time, String source) {
		this.title = title;
		this.image = image;
		this.content = conent;
		this.author = author;
		this.time = time;
		this.source = source;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}