package com.chainsys.primevideos.service;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsDAOImpl;
import com.chainsys.primevideos.exception.DbException;

@Service
public class ServiceUserCredits {
	private UserCreditsDAO credits = new UserCreditsDAOImpl();

	public boolean existMailId(String mailId) throws DbException {
		return credits.existMailId(mailId);
	}

	public boolean updatePassword(String mailId, String password) throws DbException {
		return credits.updatePassword(mailId, password);
	}

	public boolean saveUserSignUp(String name, String mailId, String password) throws DbException {
		return credits.saveUserSignUp(name, mailId, password);
	}

	public String findUserPassword(String mailId) throws DbException {
		return credits.findUserPassword(mailId);
	}

	public String findUserName(String mailId) throws DbException {
		return credits.findUserName(mailId);
	}

}
