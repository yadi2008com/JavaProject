package com.etc.server;

import com.etc.bean.AdminBean;
import com.etc.bean.StudentBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.dao.LoginDao;
import com.etc.dao.loginDaoImpl;

public class LoginServerImpl implements LoginServer {
	 LoginDao loginDao=new loginDaoImpl();

	@Override
	public int adminLogin(AdminBean adminBean) {
		int rows=0;
		try {
			rows=loginDao.adminLogin(adminBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int teacherLogin(TeacherInfoBean teacherInfoBean) {
		int rows=0;
		try {
			rows=loginDao.teacherLogin(teacherInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int studentLogin(StudentBean studentBeen) {
		int rows=0;
		try {
			rows=loginDao.studentLogin(studentBeen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	

}
