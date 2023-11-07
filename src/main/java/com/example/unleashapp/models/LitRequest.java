package com.example.unleashapp.models;

import java.io.Serializable;

public class LitRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String title;
	private String url;
	private int num;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	

}
