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
	public  void insertSignUp(@RequestParam("mailid") String mail,@RequestParam("password") String pass ) {
		UserCreditsDAO obj= new UserCreditsImp();
		try {
			obj.insertSignUp(mail, pass);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
