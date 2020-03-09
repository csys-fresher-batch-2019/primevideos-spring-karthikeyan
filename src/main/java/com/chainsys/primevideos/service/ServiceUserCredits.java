package com.chainsys.primevideos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsImp;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.UserCredits;

@Service
public class ServiceUserCredits {
	private UserCreditsDAO credits = new UserCreditsImp();

	public void userUpdate(UserCredits users) throws DbException {
		credits.userUpdate(users);
	}

	public boolean userLogin(String mailId) throws DbException {
		return credits.userLogin(mailId);
	}

	public boolean resetPassword(String mailId) throws DbException {
		return credits.resetPassword(mailId);
	}

	public boolean verifyOTPAndUpdatePassword(String mailId, String password) throws DbException {
		return credits.verifyOTPAndUpdatePassword(mailId, password);
	}

	public boolean userSignUp(String mailId, String password) throws DbException {
		return credits.userSignUp(mailId, password);
	}

	public void insertSignUp(String mailId, String password) throws DbException {
		credits.userSignUp(mailId, password);
	}

	public boolean insertSignUp1(String name, String mailId, String password) throws DbException {
		return credits.insertSignUp1(name, mailId, password);
	}

	public String password(String mailId) throws DbException {
		return credits.password(mailId);
	}

	public boolean profile(String mailIds) throws DbException {
		return credits.profile(mailIds);
	}

	public List<UserCredits> list() throws DbException {
		return credits.list();
	}

	public String userName(String mailId) throws DbException {
		return credits.userName(mailId);
	}

	public List<UserCredits> list1() throws DbException {
		return credits.list1();
	}
}
