package com.chainsys.primevideos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsDAOImpl;
import com.chainsys.primevideos.exception.DbException;

@RestController
@RequestMapping("api")
public class UserCreditsController {
	@PostMapping("/insertsignup")
	public void insertSignUp(@RequestParam("mailid") String mail, 
							@RequestParam("username") String name,
			                @RequestParam("password") String pass) 
	{
		UserCreditsDAO obj = new UserCreditsDAOImpl();
		try {
			obj.saveUserSignUp(name, mail, pass);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@PutMapping("/updatePassword")
	public boolean verifyOTPAndUpdatePassword(@RequestParam("mailid") String mailId,@RequestParam("pass") String password)  {
				UserCreditsDAO obj1= new UserCreditsDAOImpl();
		try {
			return obj1.updatePassword(mailId, password);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return false;
	}
	@GetMapping("/entryPass")
	public String password(@RequestParam("mailid") String mailId) {
		UserCreditsDAO obj1= new UserCreditsDAOImpl();
		try {
			return obj1.findUserPassword(mailId);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return null;
	}
}
