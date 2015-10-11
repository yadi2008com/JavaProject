package com.etc.server;

import java.util.List;

import com.etc.bean.BuildinginfoBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.dao.BuildinginfoDao;
import com.etc.dao.BuildinginfoDaoImpl;

public class BuildinginfoServerImpl implements BuildinginfoServer {

	@Override
	public List<BuildinginfoBean> fetchAllBuildinfo() {
		List<BuildinginfoBean> buildinginfoBeans=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		buildinginfoBeans=buildinginfoDao.fetchAllBuildinfo();
		return buildinginfoBeans;
	}

	

	@Override
	public int deleteBuildingById(int id) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.deleteBuildingById(id);
		
		return result;
	}



	@Override
	public int addBuilding(BuildinginfoBean buildinginfoBean) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.addBuilding(buildinginfoBean);
		
		return result;
	}



	@Override
	public boolean isBuildingExits(String name) {
		boolean flag=false;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		flag=buildinginfoDao.isBuildingExits(name);
		return flag;
	}



	@Override
	public BuildinginfoBean fetchBuildinginfoById(int id) {
		BuildinginfoBean buildinginfoBean=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		buildinginfoBean=buildinginfoDao.fetchBuildinginfoById(id);
		return buildinginfoBean;
	}



	@Override
	public int updateBuilding(BuildinginfoBean buildinginfoBean) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.updateBuilding(buildinginfoBean);
		
		return result;
	}



	@Override
	public BuildinginfoBean fetchBuildinginfoByName(String searchKey) {
		BuildinginfoBean buildinginfoBean=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		buildinginfoBean=buildinginfoDao.fetchBuildinginfoByName(searchKey);
		return buildinginfoBean;
	}



	@Override
	public List<TeacherInfoBean> fetchTeacherinfoByBuildingId(int id) {
		List<TeacherInfoBean> teacherInfoBeans=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		teacherInfoBeans=buildinginfoDao.fetchTeacherinfoByBuildingId(id);
		return teacherInfoBeans;
	}



	@Override
	public int deleteBuildingTeacherById(int id) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.deleteBuildingTeacherById(id);
		
		return result;
	}



	@Override
	public List<TeacherInfoBean> fetchNotAssignTeachers() {
		List<TeacherInfoBean> teacherInfoBeans=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		teacherInfoBeans=buildinginfoDao.fetchNotAssignTeachers();
		return teacherInfoBeans;
	}



	@Override
	public int addBuildingTeacher(int buildingId,
			int teacherId) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.addBuildingTeacher(buildingId,
				teacherId);
		
		return result;
	}



	@Override
	public int getBuildinginfoRows() {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.getBuildinginfoRows();
		
		return result;
	}



	@Override
	public List<BuildinginfoBean> fetchBuildinfoByPageno(int pageno) {
		List<BuildinginfoBean> buildinginfoBeans=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		buildinginfoBeans=buildinginfoDao.fetchBuildinfoByPageno(pageno);
		return buildinginfoBeans;
	}



	@Override
	public List<TeacherInfoBean> fetchTeacherinfoByBuildingIdPageno(int id,
			int pageno) {
		List<TeacherInfoBean> teacherInfoBeans=null;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		teacherInfoBeans=buildinginfoDao.fetchTeacherinfoByBuildingIdPageno(id,pageno);
		return teacherInfoBeans;
	}



	@Override
	public int getBuildingTeacherinfoRowsByBuildingId(int id) {
		int result=0;
		BuildinginfoDao buildinginfoDao=new BuildinginfoDaoImpl();
		result=buildinginfoDao.getBuildingTeacherinfoRowsByBuildingId(id);
		
		return result;
	}

}
