package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.etc.bean.AdminBean;
import com.etc.bean.StudentBean;
import com.etc.bean.TeacherInfoBean;
import com.etc.util.DBUtil;

public class loginDaoImpl implements LoginDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int adminLogin(AdminBean adminBean) throws Exception{
		int rows = 0;
		connection=dbUtil.getConnection();
		String sql="select count(*) from admin where username=? and userpwd=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, adminBean.getUsername());
		preparedStatement.setString(2, adminBean.getUserpwd());
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			rows=resultSet.getInt(1);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int teacherLogin(TeacherInfoBean teacherInfoBean) throws Exception {
		int rows = 0;
		connection=dbUtil.getConnection();
		String sql="select count(*) from teacher where username=? and userpwd=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, teacherInfoBean.getUsername());
		preparedStatement.setString(2, teacherInfoBean.getUserpwd());
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			rows=resultSet.getInt(1);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int studentLogin(StudentBean studentBeen) throws Exception {
		int rows = 0;
		connection=dbUtil.getConnection();
		String sql="select count(*) from student where username=? and userpwd=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, studentBeen.getUsername());
		preparedStatement.setString(2, studentBeen.getUserpwd());
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			rows=resultSet.getInt(1);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}

}
