package com.chainsys.primevideos.util;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.exception.DbException;
@Component
public class EmailMessages 
{
	private EmailMessages() {
		
	}
	static Scanner sc = new Scanner(System.in);
	static Logger logger = Logger.getInstance();
	public static boolean main(int random, String mailId) throws DbException {
		
        String subject = "Verify your new Amazon account";    
        String bodyContent = "To verify your email address,\nplease use the following One Time Password (OTP):\n\n\n "+random+"\n\nDo not share this OTP with anyone.\nPrime takes your account security very seriously. ";
        return mailOtpCheck(random, mailId, subject, bodyContent);
	}
	public static boolean changePassword(int random,String mailId) throws DbException {
		
        String subject = "Prime password assistance";
        String bodyContent = "Password assistance \n\n\n To authenticate, please use the following One Time Password (OTP): \n\n\n "+random+"Do not share this OTP with anyone. \nPrime takes your account security very seriously.";
        return mailOtpCheck(random, mailId, subject, bodyContent);
	}
	private static boolean mailOtpCheck(int random, String mailId, String subject, String bodyContent)
			throws DbException {
		MailUtil.send(mailId,subject,bodyContent,1);
        logger.info("Enter the OTP");
        logger.info("OTP send to your MailId");
		int a = sc.nextInt();
		if(a == random)
		{
			return true;
		}
		else
		{
			logger.info("OTP entered is Incorrect");		
			return false;
		}
	}
public static void otpjsp(int random, String mailId) throws DbException {
		
        String subject = "Verify your new Amazon account";    
        String bodyContent = "To verify your email address,\nplease use the following One Time Password (OTP):\n\n\n "+random+"\n\nDo not share this OTP with anyone.\nPrime takes your account security very seriously. ";
        MailUtil.send(mailId, subject, bodyContent, 1);
}
	
}
