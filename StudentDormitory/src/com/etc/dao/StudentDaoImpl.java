package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.bean.StudentBean;
import com.etc.util.DBUtil;

public class StudentDaoImpl implements StudentDao{
	DBUtil dbUtil=new DBUtil();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;

	@Override
	public void addStudent(StudentBean studentBean) throws Exception {
		
		connection =dbUtil.getConnection();
		String sql="insert into student(username,userpwd,name,classes,sex) "
				+ "values (?,?,?,?,?)";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, studentBean.getUsername());
		preparedStatement.setString(2, studentBean.getUserpwd());
		preparedStatement.setString(3, studentBean.getName());
		preparedStatement.setString(4, studentBean.getClasses());
		preparedStatement.setString(5, studentBean.getSex());
		
		preparedStatement.executeUpdate();
		
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
	}

	@Override
	public List<StudentBean> fetchAllUserinfoList() throws Exception {
		List<StudentBean> studentBeanList=null;
		connection=dbUtil.getConnection();
		String sql="select * from student";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		studentBeanList=new  ArrayList<StudentBean>();//使用list创建用户信息列表对象
		while(resultSet.next()){
			StudentBean studentBean=new StudentBean();
			studentBean.setId(resultSet.getInt("id"));
			studentBean.setUsername(resultSet.getString("username"));
			studentBean.setUserpwd(resultSet.getString("userpwd"));
			studentBean.setName(resultSet.getString("name"));
			studentBean.setSex(resultSet.getString("sex"));
			studentBean.setClasses(resultSet.getString("classes"));
			
			studentBeanList.add(studentBean);//将登录用户实例对象加入用户信息列表
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return studentBeanList;
	}

	@Override
	public StudentBean fetchUserInfoById(int id)throws Exception {
		StudentBean studentBean=null;
		connection =dbUtil.getConnection();
		String sql="select * from student where id=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			studentBean=new StudentBean();
			studentBean.setId(resultSet.getInt("id"));
			studentBean.setUsername(resultSet.getString("username"));
			studentBean.setUserpwd(resultSet.getString("userpwd"));
			studentBean.setName(resultSet.getString("name"));
			studentBean.setSex(resultSet.getString("sex"));
			studentBean.setClasses(resultSet.getString("classes"));
		}
	    
		
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		
		return studentBean;
	}

	@Override
	public int updateStudent(StudentBean studentBean)throws Exception {
		int rows=0;
		String sql="update student set username=?,userpwd=?,name=?,classes=?,sex=? where id=?";
		connection=dbUtil.getConnection();
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,studentBean.getUsername());
		preparedStatement.setString(2,studentBean.getUserpwd());
		preparedStatement.setString(3,studentBean.getName());
		preparedStatement.setString(4,studentBean.getClasses());
		preparedStatement.setString(5,studentBean.getSex());
		preparedStatement.setInt(6,studentBean.getId());
		
		rows=preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
		
	}
	@Override
	public StudentBean fetchStudentInfoByUsername(String username) throws Exception{
		StudentBean studentBean=null;
		
		connection =dbUtil.getConnection();
		String sql="select name from student where username=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,username);
		
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
			studentBean=new StudentBean();

			
			studentBean.setName(resultSet.getString("name"));
			
	    }
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		
		return studentBean;
			}
	

}
