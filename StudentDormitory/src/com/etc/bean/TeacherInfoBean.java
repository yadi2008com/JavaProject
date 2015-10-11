package com.etc.bean;

import java.io.Serializable;

public class TeacherInfoBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String userpwd;
	private String telephone;
	private String name;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
