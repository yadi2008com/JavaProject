package com.etc.bean;

import java.sql.Timestamp;

public class AbsenceBean {
	private int id;
	private int stu_id;
	private String note;
	private Timestamp time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
