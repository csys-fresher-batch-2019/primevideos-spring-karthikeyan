package com.chainsys.primevideos.service;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.ServiceException;
import com.chainsys.primevideos.exception.ValidatorException;
import com.chainsys.primevideos.validation.UserCreditsValidator;

@Service
public class ServiceUserCredits {
	private UserCreditsDAO credits = new UserCreditsDAOImpl();
	UserCreditsValidator validator = new UserCreditsValidator();

	public boolean existMailId(String mailId) throws ServiceException {
		boolean a = false;
		try {
			validator.validateMailId(mailId);
			 a = credits.existMailId(mailId);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return a;

	}

	public boolean updatePassword(String mailId, String password) throws ServiceException {
		boolean a = false;
		try {
			validator.validateMailId(mailId);
			validator.validatePassword(password);
			a =  credits.updatePassword(mailId, password);
		}catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return a;
	}

	public boolean saveUserSignUp(String name, String mailId, String password) throws ServiceException {
		boolean a = false;
		try{
			validator.validateSaveUser(name, mailId, password);
		    a = credits.saveUserSignUp(name, mailId, password);
		}catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return a;
	}

	public String findUserPassword(String mailId) throws ServiceException {
		try{
			validator.validateMailId(mailId);
		return credits.findUserPassword(mailId);
		}catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public String findUserName(String mailId) throws ServiceException {
		
		try{
			validator.validateMailId(mailId);
			return credits.findUserName(mailId);
		}catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	

}
}
