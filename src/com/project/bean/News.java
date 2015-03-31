package com.project.bean;

import java.util.Date;


/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private String author;
     private String source;
     private Date time;
     private Integer number;
     private String content;


    // Constructors

    /** default constructor */
    public News() {
    }

	/** minimal constructor */
    public News(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
    
    /** full constructor */
    public News(String title, String author, String source, Date time, Integer number, String content) {
        this.title = title;
        this.author = author;
        this.source = source;
        this.time = time;
        this.number = number;
        this.content = content;
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

    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }

    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}