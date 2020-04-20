package com.chainsys.primevideos.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println("--HttpSessionListener#sessionCreatedinvoked--");
		HttpSession sessions = session.getSession();
		System.out.println("session id: "+sessions.getId());
		sessions.setMaxInactiveInterval(5*60);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		System.out.println("--HttpSessionListener#SessionDestroyedinvoked --");
		
	}
	
}


