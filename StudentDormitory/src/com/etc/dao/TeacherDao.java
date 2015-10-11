package com.etc.dao;

import java.util.List;

import com.etc.bean.TeacherInfoBean;

public interface TeacherDao {

	public List<TeacherInfoBean> fetchAllTeacherinfo() throws Exception;

	public int IsTeacherUsernameRepeat(String username) throws Exception;

	public int TeacherinfoAdd(TeacherInfoBean teacherInfoBean) throws Exception;

	public int TeacherinfoDeleteById(int id) throws Exception;

	public TeacherInfoBean TeacherinfoFetchById(int id) throws Exception;

	public int TeacherinfoUpdate(TeacherInfoBean teacherInfoBean) throws Exception;

	public TeacherInfoBean TeacherinfoFetchIdByUsername(String username) throws Exception;

	public List<TeacherInfoBean> TeacherinfoFetchIdByName(String name)  throws Exception;

	public List<TeacherInfoBean> TeacherinfoFetchIdByTelephone(String name) throws Exception;
	public TeacherInfoBean fetchTeacherInfoByName(String current_name)throws Exception;

	public int TeacherinfoUpdate(int id, String password2)throws Exception;

}
