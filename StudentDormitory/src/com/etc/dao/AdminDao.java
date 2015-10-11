package com.etc.dao;

import com.etc.bean.AdminBean;

public interface AdminDao {

	public AdminBean AdmininfoFetchByUsername(String username) throws Exception;

	public int AdmininfoUpdate(AdminBean adminBean2) throws Exception;
    
}
