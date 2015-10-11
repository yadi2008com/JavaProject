package com.etc.server;

import com.etc.bean.AdminBean;

public interface AdminServer {

	public AdminBean AdmininfoFetchByUsername(String username);

	public int AdmininfoUpdate(AdminBean adminBean2);

}
