package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.CategoryDAO;
import com.chainsys.primevideos.dao.imp.PrimeCategorysImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Categorys;

@Service
public class ServiceCategory {
	
	CategoryDAO categoryDAO = new PrimeCategorysImp();
	public void addCategorys(int id, String category) throws DbException{
		categoryDAO.addCategorys(id, category);
	}
	
	public void updateCategory(int categoryid,String categoryname) throws DbException{
		categoryDAO.updateCategory(categoryid, categoryname);
	}

	public void deleteUpdateCategorys(int categoryId) throws  DbException{
		categoryDAO.deleteCategorys(categoryId);
	}

	public ArrayList<Categorys> getcategorys() throws DbException{
		return categoryDAO.getcategorys();
		
		
	}
}
