package com.etc.server;

import com.etc.bean.AdminBean;
import com.etc.bean.StudentBean;
import com.etc.bean.TeacherInfoBean;

public interface LoginServer {

	int adminLogin(AdminBean adminBean);

	int teacherLogin(TeacherInfoBean teacherInfoBean);

	int studentLogin(StudentBean studentBeen);

}
