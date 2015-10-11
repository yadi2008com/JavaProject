package com.etc.server;

import java.util.List;

import com.etc.bean.BuildinginfoBean;
import com.etc.bean.TeacherInfoBean;

public interface BuildinginfoServer {

	List<BuildinginfoBean> fetchAllBuildinfo();

	int deleteBuildingById(int id);

	int addBuilding(BuildinginfoBean buildinginfoBean);

	boolean isBuildingExits(String name);

	BuildinginfoBean fetchBuildinginfoById(int id);

	int updateBuilding(BuildinginfoBean buildinginfoBean);

	BuildinginfoBean fetchBuildinginfoByName(String searchKey);

	List<TeacherInfoBean> fetchTeacherinfoByBuildingId(int id);

	int deleteBuildingTeacherById(int id);

	List<TeacherInfoBean> fetchNotAssignTeachers();

	int addBuildingTeacher(int buildingId, int teacherId);

	int getBuildinginfoRows();

	List<BuildinginfoBean> fetchBuildinfoByPageno(int pageno);

	List<TeacherInfoBean> fetchTeacherinfoByBuildingIdPageno(int id, int pageno);

	int getBuildingTeacherinfoRowsByBuildingId(int id);



}
