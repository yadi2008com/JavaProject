package com.etc.server;

import java.util.List;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;

public interface StudentAbsenceServe {

	public List<AbsenceBean> fetchStudentAbsenceInfo();

	public int addAbsenceInfo(AbsenceBean absence);

	public AbsenceBean fetchStudentAbsenceInfoById(int id);

	public int updateStudentAbsenceInfo(AbsenceBean absence);

	public int deleteStudentAbsenceinfoById(int id);

	public List<StudentBean> fetchAbsenceStudentInfoByStu_id(int stu_id);
	public List<AbsenceBean> fetchAbsenceStudentInfoByUsername(String username);

}
