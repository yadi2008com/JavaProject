package com.etc.server;

import java.util.List;

import com.etc.bean.StudentBean;
import com.etc.dao.StudentDao;
import com.etc.dao.StudentDaoImpl;

public class StudentServerImpl implements StudentServer {
StudentDao studentDao=new StudentDaoImpl();
	@Override
	public boolean addStudent(StudentBean studentBean) {
		boolean result=false;
		
		try {
			studentDao.addStudent(studentBean);
			result=true;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<StudentBean> fetchAllUserinfoList() {
		List<StudentBean> userinfoBeanList=null;
		try {
			userinfoBeanList=studentDao.fetchAllUserinfoList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userinfoBeanList;
	}
	@Override
	public StudentBean fetchStudentInfoById(int id) {
		StudentBean studentBean=null;
		try {
			studentBean=studentDao.fetchUserInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentBean;
	}
	@Override
	public int updateStudent(StudentBean studentBean) {
		
		int result=0;
		try {
			result=studentDao.updateStudent(studentBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public StudentBean fetchStudentInfoByUsername(String username) {
		StudentBean studentBean=null;
		try {
			studentBean=studentDao.fetchStudentInfoByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentBean;
	}
}
