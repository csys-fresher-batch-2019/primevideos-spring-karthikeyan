package com.chainsys.primevideos.validation;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.exception.ValidatorException;

@Component
public class CategoryValidator {
	public void validateCategorysId(int id) throws ValidatorException{
		if(id <= 0) {
			throw new ValidatorException(InfoMessages.VALIDATECATEGORYID);
		}
	}
	public void validateCategorysName(String category) throws ValidatorException{
		if(category == null || "".equals(category.trim())) {
			throw new ValidatorException(InfoMessages.VALIDATECATEGORYNAME);
		}
	}

}
