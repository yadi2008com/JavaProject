package com.etc.server;

import java.util.List;

import com.etc.bean.DormitoryBean;

public interface DormitoryServer {

	List<DormitoryBean> fetchAllDormitoryList();

	int addDormitoryinfo(DormitoryBean dormitoryBean);

	List<DormitoryBean> DormitoryFetchNameByBuildId(int id);

}
