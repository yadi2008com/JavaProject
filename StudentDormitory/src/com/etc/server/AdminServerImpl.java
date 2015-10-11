package com.etc.server;

import com.etc.bean.AdminBean;
import com.etc.dao.AdminDao;
import com.etc.dao.AdminDaoImpl;


public class AdminServerImpl implements AdminServer {
    AdminDao adminDao=new AdminDaoImpl();
	@Override
	public AdminBean AdmininfoFetchByUsername(String username) {
		AdminBean adminBean=null;
		try {
			adminBean=adminDao.AdmininfoFetchByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminBean;
	}

	@Override
	public int AdmininfoUpdate(AdminBean adminBean2) {
		int result=0;
		try {
			result=adminDao.AdmininfoUpdate(adminBean2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
