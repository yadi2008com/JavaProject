package com.etc.server;

import java.util.List;

import com.etc.bean.StudentBean;

public interface StudentServer {

	public boolean addStudent(StudentBean studentBean);

	public List<StudentBean> fetchAllUserinfoList();

	public StudentBean fetchStudentInfoById(int id);

	public int updateStudent(StudentBean studentBean);
	
	public StudentBean fetchStudentInfoByUsername(String username);

}
