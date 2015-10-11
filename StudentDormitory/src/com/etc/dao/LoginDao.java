package com.etc.dao;

import com.etc.bean.AdminBean;
import com.etc.bean.StudentBean;
import com.etc.bean.TeacherInfoBean;

public interface LoginDao {

	int adminLogin(AdminBean adminBean) throws Exception;

	int teacherLogin(TeacherInfoBean teacherInfoBean) throws Exception;

	int studentLogin(StudentBean studentBeen) throws Exception;

}
