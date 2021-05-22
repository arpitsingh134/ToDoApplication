package com.entity;

import java.util.Date;

import javax.persistence.*;
@Entity
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private Date addedDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ToDo(String title, String content, Date addedDate) {
		super();
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ToDo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	

}
