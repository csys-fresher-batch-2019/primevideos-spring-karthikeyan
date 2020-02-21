package com.chainsys.primevideos.util;

import java.security.SecureRandom;

public class OTPUtil {
	
	private OTPUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	
	private static final SecureRandom rand = new SecureRandom();
	public static int getOTP() {
	
        return rand.nextInt(1000000); 
        
	}
}
