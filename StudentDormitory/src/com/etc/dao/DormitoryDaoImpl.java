package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.etc.bean.DormitoryBean;
import com.etc.util.DBUtil;

public class DormitoryDaoImpl implements DormitoryDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<DormitoryBean> fetchAllDormitoryList() throws Exception {
		List<DormitoryBean> dormitoryBeanList= new ArrayList<DormitoryBean>();
		connection=dbUtil.getConnection();
		String sql="select room.id,room.build_id,room.number,room.`name`,building.`name` name1 from room,building where room.build_id=building.id  ";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			DormitoryBean dormitoryBean = new DormitoryBean();
			dormitoryBean.setBuild_id(resultSet.getInt("build_id"));
			dormitoryBean.setBuild_name(resultSet.getString("name1"));
			dormitoryBean.setId(resultSet.getInt("id"));
			dormitoryBean.setName(resultSet.getString("name"));
			dormitoryBean.setNumber(resultSet.getInt("number"));
			dormitoryBeanList.add(dormitoryBean);
			
			
		}
		return dormitoryBeanList;
	}

	@Override
	public int addDormitoryinfo(DormitoryBean dormitoryBean) throws Exception {
		int rows=0;
		connection=dbUtil.getConnection();
		String sql="insert into room(name,number,build_id) values(?,?,?) ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, dormitoryBean.getName());
		preparedStatement.setInt(2, dormitoryBean.getNumber());
		preparedStatement.setInt(3, dormitoryBean.getBuild_id());
		rows=preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		
		return rows;
	}

	@Override
	public List<DormitoryBean> fetchAllDormitoryListByNameId(int build_id,
			String roomName) throws Exception {
		List<DormitoryBean> dormitoryBeanList= new ArrayList<DormitoryBean>();
		connection=dbUtil.getConnection();
		String sql="select room.id,room.build_id,room.number,room.`name`,building.`name` name1 from room,building where room.build_id=building.id and building.id=? and room.`name`=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, build_id);
		preparedStatement.setString(2, roomName);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			DormitoryBean dormitoryBean = new DormitoryBean();
			dormitoryBean.setBuild_id(resultSet.getInt("build_id"));
			dormitoryBean.setBuild_name(resultSet.getString("name1"));
			dormitoryBean.setId(resultSet.getInt("id"));
			dormitoryBean.setName(resultSet.getString("name"));
			dormitoryBean.setNumber(resultSet.getInt("number"));
			dormitoryBeanList.add(dormitoryBean);
			
			
		}
		return dormitoryBeanList;
	}

	@Override
	public List<DormitoryBean> fetchAllDormitoryListByName(String roomName)
			throws Exception {
		List<DormitoryBean> dormitoryBeanList= new ArrayList<DormitoryBean>();
		connection=dbUtil.getConnection();
		String sql="select room.id,room.build_id,room.number,room.`name`,building.`name` name1 from room,building where room.build_id=building.id and room.`name`=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, roomName);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			DormitoryBean dormitoryBean = new DormitoryBean();
			dormitoryBean.setBuild_id(resultSet.getInt("build_id"));
			dormitoryBean.setBuild_name(resultSet.getString("name1"));
			dormitoryBean.setId(resultSet.getInt("id"));
			dormitoryBean.setName(resultSet.getString("name"));
			dormitoryBean.setNumber(resultSet.getInt("number"));
			dormitoryBeanList.add(dormitoryBean);
			
			
		}
		return dormitoryBeanList;
	}

	@Override
	public List<DormitoryBean> fetchAllDormitoryListById(int build_id)
			throws Exception {
		List<DormitoryBean> dormitoryBeanList= new ArrayList<DormitoryBean>();
		connection=dbUtil.getConnection();
		String sql="select room.id,room.build_id,room.number,room.`name`,building.`name` name1 from room,building where room.build_id=building.id and room.build_id=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,build_id);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			DormitoryBean dormitoryBean = new DormitoryBean();
			dormitoryBean.setBuild_id(resultSet.getInt("build_id"));
			dormitoryBean.setBuild_name(resultSet.getString("name1"));
			dormitoryBean.setId(resultSet.getInt("id"));
			dormitoryBean.setName(resultSet.getString("name"));
			dormitoryBean.setNumber(resultSet.getInt("number"));
			dormitoryBeanList.add(dormitoryBean);
			
			
		}
		return dormitoryBeanList;
	}

	@Override
	public int deleteDormitoryinfo(int id) throws Exception {
		int rows=0;
		connection=dbUtil.getConnection();
		String sql="delete from room where id=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		rows=preparedStatement.executeUpdate();
		dbUtil.closeDBSource(connection, preparedStatement, resultSet);
		
		return rows;
	}

}
