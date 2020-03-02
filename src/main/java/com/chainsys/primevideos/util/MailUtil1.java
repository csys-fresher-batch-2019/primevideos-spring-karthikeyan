package com.chainsys.primevideos.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.logger.Logger;
@Component
 public class MailUtil1
{  
	 private MailUtil1() {
	 }
	 static Logger logger = new Logger();
	 private static Session getProperties() {
			Properties props = new Properties();    
	        props.put("mail.smtp.host", "smtp.gmail.com");    
	        props.put("mail.smtp.socketFactory.port", "465");    
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
	        props.put("mail.smtp.auth", "true");    
	        props.put("mail.smtp.port", "465");  
	        props.put("mail.smtp.ssl.checkserveridentity", true); 
	        Session session = Session.getInstance(props,new javax.mail.Authenticator() 
	        {    
	        	@Override
	        	protected PasswordAuthentication getPasswordAuthentication() 
	        	{    
	        		return new PasswordAuthentication("primemovieentertainments@gmail.com","Reset@123");  
	        	}      
	        });
			return session;
		}
	


	public static void send(String to,String sub,String message1,int val) throws DbException
	{  
		Session session = getProperties();        
        try 
        {    
        	MimeMessage message = new MimeMessage(session);    
        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
        	message.setSubject(sub); 
        	if(val==1)
        	{
        	Multipart multipart = messageBody(message1);
            message.setContent(multipart);  
        	}
        	else
        	{
        		Multipart multipart1 = messageBody1(to,message1);
                message.setContent(multipart1);
        	}
     
        	Transport.send(message);    
        	logger.info("message sent successfully to "+to);    
        }
        catch (MessagingException e) 
        {
        	throw new DbException(InfoMessages.MAILSEND);
        }    
	}
public static void send1(int userId, String customerName, String to, String sub, String msg2, int val) throws DbException {
		
		Session session = getProperties();    
        try 
        {    
        	MimeMessage message = new MimeMessage(session);    
        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
        	message.setSubject(sub); 
        	if(val==3)
        	{
        		Multipart multipart2 = messageBody2(userId,customerName,to,msg2);
                message.setContent(multipart2);
        	}
        	Transport.send(message);    
        	logger.info("message sent successfully to "+to);    
        }
        catch (MessagingException e) 
        {
        	throw new DbException(InfoMessages.MAILSEND);
        }    
	}


	private static Multipart messageBody(String msg3) throws MessagingException{ 
		BodyPart messageBodyPart1 = new MimeBodyPart();  
		messageBodyPart1.setText("Prime OTP Assitance");  
		BodyPart messageBodyPart2 = new MimeBodyPart(); 
		messageBodyPart2.setText("\nTo authenticate, please use the following One Time Password (OTP):");
		 
		BodyPart messageBodyPart3 = new MimeBodyPart(); 
		messageBodyPart3.setText(msg3);
		BodyPart messageBodyPart4 = new MimeBodyPart(); 
		messageBodyPart4.setText("Do not share this OTP with anyone. \nAmazon takes your account security very seriously. \nAmazon Customer Service will never ask you to disclose or \nverify your Amazon password, OTP, credit card, or banking account number. ");
		BodyPart messageBodyPart5 = new MimeBodyPart(); 
		messageBodyPart5.setText("Thanks for Using Prime Videos");

		Multipart multipart = commonCallMail(messageBodyPart1, messageBodyPart2, messageBodyPart3, messageBodyPart4,
				messageBodyPart5);
		return multipart; 
	}


 
	private static Multipart messageBody1(String to,String msg4) throws MessagingException{ 
		BodyPart messageBodyPart1 = new MimeBodyPart();  
		messageBodyPart1.setText("Prime Assitance.\nDear Prime Video User");  
		BodyPart messageBodyPart2 = new MimeBodyPart(); 
		messageBodyPart2.setText("\nYour MailId/UserID  "+to);
		BodyPart messageBodyPart3 = new MimeBodyPart(); 
		messageBodyPart3.setText("\nHas been Deleted From PrimeVideo\nSo you Are NO Longer a Prime User.\nBecause OF Following Reasons");
		BodyPart messageBodyPart4 = new MimeBodyPart(); 
		messageBodyPart4.setText("\n"+msg4);
		BodyPart messageBodyPart5 = new MimeBodyPart(); 
		messageBodyPart5.setText("\nThank you");
		
		Multipart multipart = commonCallMail(messageBodyPart1, messageBodyPart2, messageBodyPart3, messageBodyPart4,
				messageBodyPart5);
		return multipart; 
	}


 
	private static Multipart messageBody2(int userId, String customerName,String to, String msg) throws MessagingException{ 
		BodyPart messageBodyPart1 = new MimeBodyPart();  
		BodyPart messageBodyPart2 = new MimeBodyPart(); 
		BodyPart messageBodyPart3 = new MimeBodyPart(); 
		BodyPart messageBodyPart4 = new MimeBodyPart(); 
		BodyPart messageBodyPart5= new MimeBodyPart();
		messageBodyPart1.setText("Prime Video Messaging Assitance.\nDear Prime Video User");
		messageBodyPart2.setText("\nMailId/UserID  "+to+"\n");
		messageBodyPart3.setText("\n Hi "+customerName+" UserId :"+userId);
		messageBodyPart4.setText("\nNew Released Movie :");
		messageBodyPart5.setText("\n"+msg+"\nOnly on Prime Videos");
		
		
		Multipart multipart = commonCallMail(messageBodyPart1, messageBodyPart2, messageBodyPart3, messageBodyPart4,
				messageBodyPart5);
		return multipart; 


 
	}



	private static Multipart commonCallMail(BodyPart messageBodyPart1, BodyPart messageBodyPart2,
			BodyPart messageBodyPart3, BodyPart messageBodyPart4, BodyPart messageBodyPart5) throws MessagingException {
		Multipart multipart = new MimeMultipart();  
		multipart.addBodyPart(messageBodyPart1);  
		multipart.addBodyPart(messageBodyPart2);
		multipart.addBodyPart(messageBodyPart3);
		multipart.addBodyPart(messageBodyPart4);
		multipart.addBodyPart(messageBodyPart5);
		return multipart;
	}
}

	


	

 