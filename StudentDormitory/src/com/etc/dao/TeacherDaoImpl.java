package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.bean.TeacherInfoBean;
import com.etc.util.DBUtil;

public class TeacherDaoImpl implements TeacherDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<TeacherInfoBean> fetchAllTeacherinfo() throws Exception {
		List<TeacherInfoBean> teacherInfoList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		teacherInfoList = new ArrayList<TeacherInfoBean>();
		while (resultSet.next()) {
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setId(resultSet.getInt("id"));
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoList.add(teacherInfoBean);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoList;
	}

	@Override
	public int IsTeacherUsernameRepeat(String username) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "select count(*) from teacher where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			rows = resultSet.getInt(1);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int TeacherinfoAdd(TeacherInfoBean teacherInfoBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into teacher (username,userpwd,name,telephone) values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, teacherInfoBean.getUsername());
		preparedStatement.setString(2, teacherInfoBean.getUserpwd());
		preparedStatement.setString(3, teacherInfoBean.getName());
		preparedStatement.setString(4, teacherInfoBean.getTelephone());
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int TeacherinfoDeleteById(int id) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "delete from teacher where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public TeacherInfoBean TeacherinfoFetchById(int id) throws Exception {
		TeacherInfoBean teacherInfoBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoBean.setId(resultSet.getInt("id"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoBean;
	}

	@Override
	public int TeacherinfoUpdate(TeacherInfoBean teacherInfoBean)
			throws Exception {
		int result = 0;
		connection = dbUtil.getConnection();
		String sql = "update teacher set username=?,userpwd=?,telephone=?,name=? where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, teacherInfoBean.getUsername());
		preparedStatement.setString(2, teacherInfoBean.getUserpwd());
		preparedStatement.setString(3, teacherInfoBean.getTelephone());
		preparedStatement.setString(4, teacherInfoBean.getName());
		preparedStatement.setInt(5, teacherInfoBean.getId());
		result = preparedStatement.executeUpdate();
		return result;
	}

	@Override
	public TeacherInfoBean TeacherinfoFetchIdByUsername(String username) throws Exception {
		TeacherInfoBean teacherInfoBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoBean.setId(resultSet.getInt("id"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoBean;
	}

	@Override
	public List<TeacherInfoBean> TeacherinfoFetchIdByName(String name)
			throws Exception {
		List<TeacherInfoBean> teacherInfoList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher where name=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		resultSet = preparedStatement.executeQuery();
		teacherInfoList = new ArrayList<TeacherInfoBean>();
		while (resultSet.next()) {
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setId(resultSet.getInt("id"));
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoList.add(teacherInfoBean);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoList;
	}

	@Override
	public List<TeacherInfoBean> TeacherinfoFetchIdByTelephone(String name) throws Exception {
		List<TeacherInfoBean> teacherInfoList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher where telephone=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		resultSet = preparedStatement.executeQuery();
		teacherInfoList = new ArrayList<TeacherInfoBean>();
		while (resultSet.next()) {
			TeacherInfoBean teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setId(resultSet.getInt("id"));
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoList.add(teacherInfoBean);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoList;
	}
	@Override
	public TeacherInfoBean fetchTeacherInfoByName(String current_name)
			throws Exception {
		TeacherInfoBean teacherInfoBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from teacher where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, current_name);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			teacherInfoBean = new TeacherInfoBean();
			teacherInfoBean.setName(resultSet.getString("name"));
			teacherInfoBean.setUsername(resultSet.getString("username"));
			teacherInfoBean.setUserpwd(resultSet.getString("userpwd"));
			teacherInfoBean.setTelephone(resultSet.getString("telephone"));
			teacherInfoBean.setId(resultSet.getInt("id"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return teacherInfoBean;
	}

	@Override
	public int TeacherinfoUpdate(int id, String password2) throws Exception {
		int result = 0;
		connection = dbUtil.getConnection();
		String sql = "update teacher set userpwd=?where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, password2);
		preparedStatement.setInt(2, id);
		result = preparedStatement.executeUpdate();
		return result;
	}


}
