package com.project.bean;

import java.util.Date;

/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */

public class Announcement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String author;
	private Date time;
	private String content;
	private String attachment1;
	private String attachment2;
	private String attachment3;

	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** minimal constructor */
	public Announcement(String title, String author, String content) {
		this.title = title;
		this.author = author;
		this.content = content;
	}

	/** full constructor */
	public Announcement(String title, String author, Date time, String content,
			String attachment1, String attachment2, String attachment3) {
		this.title = title;
		this.author = author;
		this.time = time;
		this.content = content;
		this.attachment1 = attachment1;
		this.attachment2 = attachment2;
		this.attachment3 = attachment3;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachment1() {
		return this.attachment1;
	}

	public void setAttachment1(String attachment1) {
		this.attachment1 = attachment1;
	}

	public String getAttachment2() {
		return this.attachment2;
	}

	public void setAttachment2(String attachment2) {
		this.attachment2 = attachment2;
	}

	public String getAttachment3() {
		return this.attachment3;
	}

	public void setAttachment3(String attachment3) {
		this.attachment3 = attachment3;
	}

}