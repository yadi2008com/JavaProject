package com.etc.server;

import java.util.List;

import com.etc.bean.TeacherInfoBean;

public interface TeacherServer {

	 public List<TeacherInfoBean> fetchAllTeacherinfo();

	public int IsTeacherUsernameRepeat(String username);

	public int TeacherinfoAdd(TeacherInfoBean teacherInfoBean);

	public int TeacherinfoDeleteById(int id);

	public TeacherInfoBean TeacherinfoFetchById(int id);

	public int TeacherinfoUpdate(TeacherInfoBean teacherInfoBean);

	public TeacherInfoBean TeacherinfoFetchIdByUsername(String username);

	public List<TeacherInfoBean> TeacherinfoFetchIdByName(String name);

	public List<TeacherInfoBean> TeacherinfoFetchIdByTelephone(String name);

	public TeacherInfoBean fetchTeacherInfoByName(String current_name);
	
    public int updateTeacherPassword(int id, String password2);

}
