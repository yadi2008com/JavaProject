package com.etc.dao;

import java.util.List;

import com.etc.bean.DormitoryBean;

public interface DormitoryDao {

	List<DormitoryBean> fetchAllDormitoryList() throws Exception;

	int addDormitoryinfo(DormitoryBean dormitoryBean) throws Exception;

	List<DormitoryBean> fetchAllDormitoryListByNameId(int build_id,
			String roomName) throws Exception;

	List<DormitoryBean> fetchAllDormitoryListByName(String roomName) throws Exception;

	List<DormitoryBean> fetchAllDormitoryListById(int build_id) throws Exception;

	int deleteDormitoryinfo(int id) throws Exception;

	

}
