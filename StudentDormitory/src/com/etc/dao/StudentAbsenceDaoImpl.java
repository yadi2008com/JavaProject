package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.bean.AbsenceBean;
import com.etc.bean.StudentBean;
import com.etc.util.DBUtil;
public class StudentAbsenceDaoImpl implements StudentAbsenceDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	@Override
	public List<AbsenceBean> fetchStudentAbsenceInfo() throws Exception {
		List<AbsenceBean> absenceList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from absence ";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		absenceList = new ArrayList<AbsenceBean>();
		while (resultSet.next()) {
			AbsenceBean absence = new AbsenceBean();
			absence.setId(resultSet.getInt("id"));
			absence.setStu_id(resultSet.getInt("stu_id"));
			absence.setNote(resultSet.getString("note"));
			absence.setTime(resultSet.getTimestamp("time"));
			absenceList.add(absence);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return absenceList;
	}
	@Override
	public int addAbsenceInfo(AbsenceBean absence) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into absence (stu_id,note,time) values (?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,absence.getStu_id());
		preparedStatement.setString(2,absence.getNote());
		preparedStatement.setTimestamp(3,absence.getTime());
		rows = preparedStatement.executeUpdate();
		return rows;
	}
	@Override
	public AbsenceBean fetchStudentAbsenceInfoById(int id) throws Exception {
		AbsenceBean absence = null;
		connection = dbUtil.getConnection();
		String sql = "select * from absence where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			absence = new AbsenceBean();
			absence.setId(resultSet.getInt("id"));
			absence.setStu_id(resultSet.getInt("stu_id"));
			absence.setNote(resultSet.getString("note"));
			absence.setTime(resultSet.getTimestamp("time"));
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return absence;
	}
	@Override
	public int updateStudentAbsenceInfo(AbsenceBean absence) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "update absence set note=?,time=? where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,absence.getNote());
		preparedStatement.setTimestamp(2,absence.getTime());
		preparedStatement.setInt(3,absence.getId());
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return rows;
	}
	@Override
	public int deleteStudentAbsenceinfoById(int id) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "delete from absence where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		rows = preparedStatement.executeUpdate();
		return rows;
	}
	@Override
	public List<StudentBean> fetchAbsenceStudentInfoByStu_id(int stu_id)
			throws Exception {
		List<StudentBean> studentList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from student where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,stu_id);
		resultSet = preparedStatement.executeQuery();
		studentList = new ArrayList<StudentBean>();
		while (resultSet.next()) {
			StudentBean student = new StudentBean();
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setSex(resultSet.getString("sex"));
			student.setClasses(resultSet.getString("classes"));
			student.setTelephone(resultSet.getString("telephone"));
			student.setAge(resultSet.getInt("age"));
			student.setStatus(resultSet.getString("status"));
			studentList.add(student);
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return studentList;
	}
	@Override
	public List<AbsenceBean> fetchAbsenceStudentInfoByUsername(String username)
			throws Exception {
		List<AbsenceBean> absenceBeanList=new ArrayList<AbsenceBean>();
		
		connection =dbUtil.getConnection();
		String sql="select note,time from absence a,student s where a.stu_id=s.id AND username=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,username);
		
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
		     AbsenceBean absenceBean=new AbsenceBean();
             absenceBean.setNote(resultSet.getString("note"));
			 absenceBean.setTime(resultSet.getTimestamp("time"));
			 absenceBeanList.add(absenceBean);
		
		
		}
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		return absenceBeanList;
		
}

}
