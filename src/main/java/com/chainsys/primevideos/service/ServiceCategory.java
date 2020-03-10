package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.CategoryDAO;
import com.chainsys.primevideos.dao.imp.CategorysDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Categorys;

@Service
public class ServiceCategory {
	
	private CategoryDAO categoryDAO = new CategorysDAOImpl();
	
	public void saveCategorys(int id, String category) throws DbException{
		categoryDAO.saveCategorys(id, category);
	}
	
	public void updateCategory(int categoryid,String categoryname) throws DbException{
		categoryDAO.updateCategory(categoryid, categoryname);
	}

	public void deleteCategorys(int categoryId) throws  DbException{
		categoryDAO.deleteCategorys(categoryId);
	}

	public ArrayList<Categorys> findAllCategorys() throws DbException{
		return categoryDAO.findAllCategorys();
		
		
	}
}
