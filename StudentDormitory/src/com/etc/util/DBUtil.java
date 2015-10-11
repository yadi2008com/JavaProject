package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public Connection getConnection() throws Exception {
		Connection connection = null;
		String className = "com.mysql.jdbc.Driver";
		String password = "mysql";
		String user = "root";
		String url = "jdbc:mysql://192.168.207.35:3306/stuliving";

		Class.forName(className).newInstance();
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	/**
	 * @功能：用于关闭数据库相关的资源
	 * @参数 connection 数据库连接实例 对象
	 * @参数 preparedStatement 预编译语句的实例对象
	 * @参数 resultSet 结果集的实例对象
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */
	public void closeDBSource(Connection connection,
			PreparedStatement preparedStatement, ResultSet resultSet)
			throws Exception {
		if (connection != null) {
			connection.close();

		}
		if (preparedStatement != null) {
			preparedStatement.close();

		}
		if (resultSet != null) {
			resultSet.close();

		}

	}

}
