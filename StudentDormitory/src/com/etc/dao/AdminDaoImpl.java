package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.etc.bean.AdminBean;
import com.etc.util.DBUtil;

public class AdminDaoImpl implements AdminDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	@Override
	public AdminBean AdmininfoFetchByUsername(String username) throws Exception {
		AdminBean adminBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from admin where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			adminBean = new AdminBean();
			adminBean.setUsername(resultSet.getString("username"));
			adminBean.setUserpwd(resultSet.getString("userpwd"));
			adminBean.setId(resultSet.getInt("id"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return adminBean;
	}

	@Override
	public int AdmininfoUpdate(AdminBean adminBean2) throws Exception {
		int result = 0;
		connection = dbUtil.getConnection();
		String sql = "update admin set userpwd=? where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, adminBean2.getUserpwd());
		preparedStatement.setString(2, adminBean2.getUsername());
		result = preparedStatement.executeUpdate();
		return result;
	}

}
