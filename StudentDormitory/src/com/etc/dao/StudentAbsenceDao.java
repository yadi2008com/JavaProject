package com.etc.dao;

import java.util.List;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;

public interface StudentAbsenceDao {

	public List<AbsenceBean> fetchStudentAbsenceInfo() throws Exception;

	public int addAbsenceInfo(AbsenceBean absence)throws Exception;

	public AbsenceBean fetchStudentAbsenceInfoById(int id)throws Exception;

	public int updateStudentAbsenceInfo(AbsenceBean absence)throws Exception;

	public int deleteStudentAbsenceinfoById(int id)throws Exception;

	public List<StudentBean> fetchAbsenceStudentInfoByStu_id(int stu_id)throws Exception;
	
	public List<AbsenceBean> fetchAbsenceStudentInfoByUsername(String username)throws Exception;
}
