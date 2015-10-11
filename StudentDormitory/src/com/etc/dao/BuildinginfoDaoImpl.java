package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.bean.BuildinginfoBean;
import com.etc.bean.PageBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.util.DBUtil;


public class BuildinginfoDaoImpl implements BuildinginfoDao {
Connection connection;
PreparedStatement preparedStatement;
ResultSet resultSet;
	@Override
	public List<BuildinginfoBean> fetchAllBuildinfo() {
		List<BuildinginfoBean> buildinginfoBeans=new ArrayList<BuildinginfoBean>();
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from building";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildinginfoBean buildinginfoBean=new BuildinginfoBean();
				buildinginfoBean.setId(resultSet.getInt(1));
				buildinginfoBean.setName(resultSet.getString(2));
				buildinginfoBean.setAddress(resultSet.getString(3));
				buildinginfoBean.setContent(resultSet.getString(4));
				buildinginfoBeans.add(buildinginfoBean);
				
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return buildinginfoBeans;
	}
	@Override
	public int deleteBuildingById(int id) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="delete from building where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result=preparedStatement.executeUpdate();
			this.deleteTeacherByBuildId(id);
			this.deleteRoomByBuildId(id);
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	//删除楼的时候将manage_build中的绑定的楼管信息也删除
	private void deleteRoomByBuildId(int id) {
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="delete from manage_build where build_id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		
	}
	//删除楼的时候将room表中的绑定的teacher信息也删除
	private void deleteTeacherByBuildId(int id) {
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql=sql="delete from room where build_id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		
	}
	@Override
	public boolean isBuildingExits(String name) {
		boolean flag=false;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from building where name=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag=true;
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return flag;
	}
	@Override
	public int addBuilding(BuildinginfoBean buildinginfoBean) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="insert into building (name,address,content) values(?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, buildinginfoBean.getName());
			preparedStatement.setString(2, buildinginfoBean.getAddress());
			preparedStatement.setString(3, buildinginfoBean.getContent());
			result=preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public BuildinginfoBean fetchBuildinginfoById(int id) {
		BuildinginfoBean buildinginfoBean=null;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from building where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				buildinginfoBean=new BuildinginfoBean();
				buildinginfoBean.setId(resultSet.getInt(1));
				buildinginfoBean.setName(resultSet.getString(2));
				buildinginfoBean.setAddress(resultSet.getString(3));
				buildinginfoBean.setContent(resultSet.getString(4));
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return buildinginfoBean;
	}
	@Override
	public int updateBuilding(BuildinginfoBean buildinginfoBean) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="UPDATE building SET name=?,address=?,content=? WHERE id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, buildinginfoBean.getName());
			preparedStatement.setString(2, buildinginfoBean.getAddress());
			preparedStatement.setString(3, buildinginfoBean.getContent());
			preparedStatement.setInt(4, buildinginfoBean.getId());
			result=preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public BuildinginfoBean fetchBuildinginfoByName(String searchKey) {
		BuildinginfoBean buildinginfoBean=null;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from building where name=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, searchKey);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				buildinginfoBean=new BuildinginfoBean();
				buildinginfoBean.setId(resultSet.getInt(1));
				buildinginfoBean.setName(resultSet.getString(2));
				buildinginfoBean.setAddress(resultSet.getString(3));
				buildinginfoBean.setContent(resultSet.getString(4));
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return buildinginfoBean;
	}
	@Override
	public List<TeacherInfoBean> fetchTeacherinfoByBuildingId(int id) {
		List<TeacherInfoBean> teacherInfoBeans=new ArrayList<TeacherInfoBean>();
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from teacher t where t.id in(select teacher_id from manage_build where build_id=?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				TeacherInfoBean teacherInfoBean=new TeacherInfoBean();
				teacherInfoBean.setId(resultSet.getInt(1));
				teacherInfoBean.setName(resultSet.getString(5));
				teacherInfoBean.setUserpwd(resultSet.getString(3));
				teacherInfoBean.setUsername(resultSet.getString(2));
				teacherInfoBean.setTelephone(resultSet.getString(4));
				teacherInfoBeans.add(teacherInfoBean);
				
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return teacherInfoBeans;
	}
	@Override
	public int deleteBuildingTeacherById(int id) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="delete from manage_build where teacher_id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result=preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public List<TeacherInfoBean> fetchNotAssignTeachers() {
		List<TeacherInfoBean> teacherInfoBeans=new ArrayList<TeacherInfoBean>();
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select * from teacher t where t.id not in(select teacher_id from manage_build)";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				TeacherInfoBean teacherInfoBean=new TeacherInfoBean();
				teacherInfoBean.setId(resultSet.getInt(1));
				teacherInfoBean.setName(resultSet.getString(5));
				teacherInfoBean.setUserpwd(resultSet.getString(3));
				teacherInfoBean.setUsername(resultSet.getString(2));
				teacherInfoBean.setTelephone(resultSet.getString(4));
				teacherInfoBeans.add(teacherInfoBean);
				
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return teacherInfoBeans;
	}
	@Override
	public int addBuildingTeacher(int buildingId,
			int teacherId) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="insert into manage_build (teacher_id,build_id) values(?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, teacherId);
			preparedStatement.setInt(2, buildingId);
			result=preparedStatement.executeUpdate();
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public int getBuildinginfoRows() {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select count(*) from building";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				result=resultSet.getInt(1);
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public List<BuildinginfoBean> fetchBuildinfoByPageno(int pageno) {
		List<BuildinginfoBean> buildinginfoBeans=new ArrayList<BuildinginfoBean>();
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			int indexRows=(pageno-1)*PageBean.ROWS_PRE_PAGE;
			String sql="select * from building limit ?,?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, indexRows);
			preparedStatement.setInt(2, PageBean.ROWS_PRE_PAGE);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildinginfoBean buildinginfoBean=new BuildinginfoBean();
				buildinginfoBean.setId(resultSet.getInt(1));
				buildinginfoBean.setName(resultSet.getString(2));
				buildinginfoBean.setAddress(resultSet.getString(3));
				buildinginfoBean.setContent(resultSet.getString(4));
				buildinginfoBeans.add(buildinginfoBean);
				
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return buildinginfoBeans;
	}
	@Override
	public List<TeacherInfoBean> fetchTeacherinfoByBuildingIdPageno(int id,
			int pageno) {
		List<TeacherInfoBean> teacherInfoBeans=new ArrayList<TeacherInfoBean>();
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			int indexRows=(pageno-1)*PageBean.ROWS_PRE_PAGE;
			String sql="select * from teacher t where t.id in(select teacher_id from manage_build where build_id=?) limit ?,?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, indexRows);
			preparedStatement.setInt(3, PageBean.ROWS_PRE_PAGE);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				TeacherInfoBean teacherInfoBean=new TeacherInfoBean();
				teacherInfoBean.setId(resultSet.getInt(1));
				teacherInfoBean.setName(resultSet.getString(5));
				teacherInfoBean.setUserpwd(resultSet.getString(3));
				teacherInfoBean.setUsername(resultSet.getString(2));
				teacherInfoBean.setTelephone(resultSet.getString(4));
				teacherInfoBeans.add(teacherInfoBean);
				
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return teacherInfoBeans;
	}
	@Override
	public int getBuildingTeacherinfoRowsByBuildingId(int id) {
		int result=0;
		try {
			DBUtil dbUtil=new DBUtil();
			connection=dbUtil.getConnection();
			String sql="select count(*) from teacher t where t.id in(select teacher_id from manage_build where build_id=?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				result=resultSet.getInt(1);
			}
			dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		} catch (Exception e) {
		}
		return result;
	}

}
