package com.chainsys.primevideos.dao;

import java.util.ArrayList;

	public interface AdminInterfaceDAO{
		
		void addAdminID(String adminLoginId,String loginKey);
		
		void updateAdminId(AdminInterfaceDAO admin);
		
		void updateStatus(String adminLoginId,String loginKey,int status);
		
		ArrayList<AdminInterfaceDAO> list();
		
		ArrayList<AdminInterfaceDAO> getStatus(int status);
		
	

}
