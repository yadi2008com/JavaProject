package com.etc.server;

import java.util.List;

import com.etc.bean.TeacherInfoBean;
import com.etc.dao.TeacherDao;
import com.etc.dao.TeacherDaoImpl;

public class TeacherServerImpl implements TeacherServer {
	TeacherDao teacherDao = new TeacherDaoImpl();

	@Override
	public List<TeacherInfoBean> fetchAllTeacherinfo() {
		List<TeacherInfoBean> teacherInfoList = null;
		try {
			teacherInfoList = teacherDao.fetchAllTeacherinfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoList;
	}

	@Override
	public int IsTeacherUsernameRepeat(String username) {
		int result = 0;
		try {
			result = teacherDao.IsTeacherUsernameRepeat(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int TeacherinfoAdd(TeacherInfoBean teacherInfoBean) {
		int result = 0;
		try {
			result = teacherDao.TeacherinfoAdd(teacherInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int TeacherinfoDeleteById(int id) {
		int result = 0;
		try {
			result = teacherDao.TeacherinfoDeleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TeacherInfoBean TeacherinfoFetchById(int id) {
		TeacherInfoBean teacherInfoBean = null;
		try {
			teacherInfoBean = teacherDao.TeacherinfoFetchById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoBean;
	}

	@Override
	public int TeacherinfoUpdate(TeacherInfoBean teacherInfoBean) {
		int result = 0;
		try {
			result = teacherDao.TeacherinfoUpdate(teacherInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public TeacherInfoBean TeacherinfoFetchIdByUsername(String username) {
		TeacherInfoBean teacherInfoBean=null;
		try {
			teacherInfoBean=teacherDao.TeacherinfoFetchIdByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoBean;
	}

	@Override
	public List<TeacherInfoBean> TeacherinfoFetchIdByName(String name) {
		List<TeacherInfoBean> teacherInfoBeanList=null;
		try {
			teacherInfoBeanList=teacherDao.TeacherinfoFetchIdByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoBeanList;
	}

	@Override
	public List<TeacherInfoBean> TeacherinfoFetchIdByTelephone(String name) {
		List<TeacherInfoBean> teacherInfoList = null;
		try {
			teacherInfoList = teacherDao.TeacherinfoFetchIdByTelephone(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoList;
	}

	@Override
	public TeacherInfoBean fetchTeacherInfoByName(String current_name) {
		TeacherInfoBean teacherInfoBean=null;
		try {
			teacherInfoBean=teacherDao.fetchTeacherInfoByName(current_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoBean;
	}

	@Override
	public int updateTeacherPassword(int id, String password2) {
		int result = 0;
		try {
			result = teacherDao.TeacherinfoUpdate(id,password2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


}
