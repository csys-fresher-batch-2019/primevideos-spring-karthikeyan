package com.chainsys.primevideos.dao;

import com.chainsys.primevideos.exception.DbException;

public interface UserCreditsDAO {


	public boolean existMailId(String mailId) throws DbException;
	
	public boolean updatePassword(String mailId, String password) throws DbException;
	
	public boolean saveUserSignUp(String name,String mailId, String password) throws DbException;
	
	public String findUserPassword(String mailId) throws DbException;
		
	public String findUserName(String mailId) throws DbException;
	
}
