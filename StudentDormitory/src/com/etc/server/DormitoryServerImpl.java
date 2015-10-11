package com.etc.server;

import java.util.List;

import com.etc.bean.DormitoryBean;
import com.etc.dao.DormitoryDao;
import com.etc.dao.DormitoryDaoImpl;

public class DormitoryServerImpl implements DormitoryServer {
    DormitoryDao dormitoryDao=new DormitoryDaoImpl();
	@Override
	public List<DormitoryBean> fetchAllDormitoryList() {
		List<DormitoryBean> dormitoryBeanList=null;
		try {
			dormitoryBeanList=dormitoryDao.fetchAllDormitoryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dormitoryBeanList;
	}
	@Override
	public int addDormitoryinfo(DormitoryBean dormitoryBean) {
		int rows=0;
		try {
			rows=dormitoryDao.addDormitoryinfo(dormitoryBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public List<DormitoryBean> DormitoryFetchNameByBuildId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
