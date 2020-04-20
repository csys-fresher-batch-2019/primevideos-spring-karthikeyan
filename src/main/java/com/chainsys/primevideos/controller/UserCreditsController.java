package com.chainsys.primevideos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.dao.imp.UserCreditsDAOImpl;
import com.chainsys.primevideos.dto.Message;
import com.chainsys.primevideos.exception.DbException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class UserCreditsController {
	
	static UserCreditsDAO obj1= new UserCreditsDAOImpl();
	
	@PostMapping("/insertsignup")
	public ResponseEntity insertSignUp(@RequestParam("mailid") String mail, 
							@RequestParam("username") String name,
			                @RequestParam("password") String pass) 
	{
		try {
			obj1.saveUserSignUp(name, mail, pass);
			return new ResponseEntity(HttpStatus.OK);
		} catch (DbException e) {
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updatePassword")
	public boolean verifyOTPAndUpdatePassword(@RequestParam("mailid") String mailId,@RequestParam("pass") String password)  {

		try {
			return obj1.updatePassword(mailId, password);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return false;
	}
	@GetMapping("/entryPass")
	public String password(@RequestParam("mailid") String mailId) {
		try {
			return obj1.findUserPassword(mailId);
		
		} catch (DbException e) {
			e.printStackTrace();
		}
		return null;
	}
}
