package com.chainsys.primevideos.dao;

import java.util.ArrayList;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Categorys;

public interface CategoryDAO {

	void addCategorys(int id, String category) throws DbException;
	
	void updateCategory(int categoryid,String categoryname) throws DbException;

	void deleteCategorys(int categoryId) throws  DbException;

	ArrayList<Categorys> getcategorys() throws DbException;
	
	
}
