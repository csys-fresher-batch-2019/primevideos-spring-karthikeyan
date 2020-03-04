package com.chainsys.primevideos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsImp;
import com.chainsys.primevideos.exception.DbException;

@RestController
@RequestMapping("api")
public class UserCreditsController {
	@GetMapping("/insertsignup")
	public void insertSignUp(@RequestParam("mailid") String mail, 
							@RequestParam("username") String name,
			                @RequestParam("password") String pass) 
	{
		UserCreditsDAO obj = new UserCreditsImp();
		try {
			obj.insertSignUp1(name, mail, pass);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/updatePassword")
	public boolean verifyOTPAndUpdatePassword(@RequestParam("mailid") String mailId,@RequestParam("pass") String password)  {
				UserCreditsDAO obj1= new UserCreditsImp();
		try {
			return obj1.verifyOTPAndUpdatePassword(mailId, password);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return false;
	}
	@GetMapping("/entryPass")
	public String password(@RequestParam("mailid") String mailId) {
		UserCreditsDAO obj1= new UserCreditsImp();
		try {
			return obj1.password(mailId);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return null;
	}
}
