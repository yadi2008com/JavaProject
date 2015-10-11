package com.etc.dao;

import java.util.List;

import com.etc.bean.StudentBean;

public interface StudentDao {

	public void addStudent(StudentBean studentBean)throws Exception;

	public List<StudentBean> fetchAllUserinfoList ()throws Exception;

	public StudentBean fetchUserInfoById(int id)throws Exception;

	public int updateStudent(StudentBean studentBean) throws Exception;
	public StudentBean fetchStudentInfoByUsername(String username)throws Exception;

}
