package com.chainsys.primevideos.util;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;
@Component
public class OTPUtil {
	
	/*public OTPUtil() {
	    throw new IllegalStateException("Utility class");
	  }*/
	
	public static final SecureRandom rand = new SecureRandom();
	public static int getOTP() {
	
        return rand.nextInt(1000000); 
        
	}
}
