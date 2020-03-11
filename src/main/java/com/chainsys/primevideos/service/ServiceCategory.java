package com.chainsys.primevideos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.CategoryDAO;
import com.chainsys.primevideos.dao.imp.CategorysDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.ServiceException;
import com.chainsys.primevideos.exception.ValidatorException;
import com.chainsys.primevideos.model.Category;
import com.chainsys.primevideos.validation.CategoryValidator;

@Service
public class ServiceCategory {

	private CategoryDAO categoryDAO = new CategorysDAOImpl();
	CategoryValidator validator = new CategoryValidator();

	public void saveCategorys(int id, String category) throws ServiceException {
		try {
			validator.validateCategorysId(id);
			validator.validateCategorysName(category);
			categoryDAO.saveCategorys(id, category);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateCategory(int categoryid, String categoryname) throws ServiceException {
		try {
			validator.validateCategorysId(categoryid);
			validator.validateCategorysName(categoryname);
			categoryDAO.updateCategory(categoryid, categoryname);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void deleteCategorys(int categoryId) throws ServiceException {
		try {
			validator.validateCategorysId(categoryId);
			categoryDAO.deleteCategorys(categoryId);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Category> findAllCategorys() throws ServiceException {
		List<Category> ls = new ArrayList<>();
		try {
			ls = categoryDAO.findAllCategorys();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return ls;
	}
}