package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Category;

public interface CategoryDAO {

	void saveCategorys(int id, String category) throws DbException;
	
	void updateCategory(int categoryid,String categoryname) throws DbException;

	void deleteCategorys(int categoryId) throws  DbException;

	List<Category> findAllCategorys() throws DbException;
	
	
}
