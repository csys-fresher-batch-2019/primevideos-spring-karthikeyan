package com.chainsys.primevideos.validation;

import com.chainsys.primevideos.exception.DbException;

public class UserCreditsValidation {
	
	public static void existMailId(String mailID) throws DbException{
		if ( mailID == null || "".equals(mailID.trim())) {
			try {
				throw new Exception("Email cannot be null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
