package com.chainsys.primevideos.exception;

public class InfoMessages {

	private InfoMessages() {
	    throw new IllegalStateException("Utility class");
	  }
   public static final String CONNECTION = "Unable to Establih Connection 'SERVER ERROR'";  
   public static final String ADPLAN="Unable To Add Plan";
   public static final String VIEWPLAN= "Unable To View Plans";
   public static final String DELETEPLAN= "Unable To Delete a Plan";
   public static final String UPDATEPLAN= "Unable To Update a Plan";
   public static final String ADDCATEGORY="Unable To Add Category";
   public static final String VIEWCATEGORY= "Unable To View Category";
   public static final String DELETECATEGORY= "Unable To Delete a Category";
   public static final String UPDATECATEGORY= "Unable To Update a Category";
   public static final String ADDVIDEO="Unable To Add Video";
   public static final String VIEWVIDEO= "Unable To View Video";
   public static final String DELETEVIDEO= "Unable To Delete a Video";
   public static final String UPDATEVIDEO= "Unable To Update a Video";
   public static final String ADDUSER="Unable To Add UserCredits";
   public static final String VIEWUSER= "Unable To View UserProfile";
   public static final String DELETEUSER= "Unable To Delete UserCredits";
   public static final String UPDATEUSER= "Unable To Update UserProfile";
   public static final String MAILCHECK = "Unable to verify the MailID";
   public static final String VERIFYOTP = "Unable to verify the Otp and Change Password Operation";
   public static final String SIGNUPADD = "Unable to verify the Perform SignUp Operation";
   public static final String PASSCHECK = "Unable Perform Password Check";
   public static final String MAILSEND =  "Mail Cannot Be Send";
   public static final String OPERATION =  "Cannot Able to Perform This Operation";
}
