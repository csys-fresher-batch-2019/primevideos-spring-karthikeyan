package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.UserCredits;

public interface UserCreditsDAO {

	void userUpdate(UserCredits users) throws DbException;

	boolean userLogin(String mailId) throws DbException;

	boolean deleteUser(String mailId) throws DbException;
	
	boolean resetPassword(String mailId) throws DbException;
	
	boolean verifyOTPAndUpdatePassword(String mailId, String password) throws DbException;
	
	boolean userSignUp(String mailId,String password) throws DbException;
	
	void insertSignUp(String mailId, String password) throws DbException;
	
	boolean insertSignUp1(String name,String mailId, String password) throws DbException;
	
	String password(String mailId) throws DbException;
	
	boolean profile(String mailIds) throws DbException;
	
	String userName(String mailId) throws DbException;
	
	List<UserCredits> list() throws DbException;
	
	List<UserCredits> list1() throws DbException;
}
