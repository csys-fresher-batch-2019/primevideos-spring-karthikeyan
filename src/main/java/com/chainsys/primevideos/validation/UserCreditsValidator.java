package com.chainsys.primevideos.validation;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.exception.ValidatorException;

@Component
public class UserCreditsValidator {
	
	public void validateMailId(String mailId) throws ValidatorException {
		if (mailId == null || "".equals(mailId.trim())) {
			throw new ValidatorException(InfoMessages.VALIDATEEmail);
		}
	}
	public void validateSaveUser(String name, String mailId, String password) throws ValidatorException{
		if (name == null || "".equals(name.trim())) {
			throw new ValidatorException(InfoMessages.VALIDATENAME);
		}
		if (mailId == null || "".equals(mailId.trim())) {
			throw new ValidatorException(InfoMessages.VALIDATEEmail);
		}
		if (password == null || "".equals(password.trim()) || password.length()<8) {
			throw new ValidatorException(InfoMessages.VALIDATEPASSWORD);
		}
		
	}
	public void validatePassword(String password) throws ValidatorException {
		if (password == null || "".equals(password.trim()) || password.length()<8) {
			throw new ValidatorException(InfoMessages.VALIDATEPASSWORD);
		}	
	}
}