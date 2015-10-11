package com.etc.server;

import java.util.List;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;
import com.etc.dao.StudentAbsenceDao;
import com.etc.dao.StudentAbsenceDaoImpl;


public class StudentAbsenceServeImpl implements StudentAbsenceServe {
	StudentAbsenceDao studentAbsenceDao = new StudentAbsenceDaoImpl();
	@Override
	public List<AbsenceBean> fetchStudentAbsenceInfo() {
		List<AbsenceBean> absenceList = null;
		try {
			absenceList = studentAbsenceDao.fetchStudentAbsenceInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absenceList;
	}
	@Override
	public int addAbsenceInfo(AbsenceBean absence) {
		int i = 0;
		try {
			i = studentAbsenceDao.addAbsenceInfo(absence);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public AbsenceBean fetchStudentAbsenceInfoById(int id) {
		AbsenceBean absence = null;
		try {
			absence = studentAbsenceDao.fetchStudentAbsenceInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absence;
	}
	@Override
	public int updateStudentAbsenceInfo(AbsenceBean absence) {
		int i = 0;
		try {
			i = studentAbsenceDao.updateStudentAbsenceInfo(absence);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int deleteStudentAbsenceinfoById(int id) {
		int i = 0;
		try {
			i = studentAbsenceDao.deleteStudentAbsenceinfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<StudentBean> fetchAbsenceStudentInfoByStu_id(int stu_id) {
		List<StudentBean> studentList = null;
		try {
			studentList = studentAbsenceDao.fetchAbsenceStudentInfoByStu_id(stu_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
	@Override
	public List<AbsenceBean> fetchAbsenceStudentInfoByUsername(String username) {
		List<AbsenceBean> absenceBeanList=null;
		try {
			 absenceBeanList=studentAbsenceDao.fetchAbsenceStudentInfoByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absenceBeanList;
	}

}
