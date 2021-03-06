package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.ServiceException;
import com.chainsys.primevideos.service.ServiceUserCredits;
import com.chainsys.primevideos.util.Logger;
@WebServlet("/LogInMail")
public class LogInMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();
       
    public LogInMail() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("email");		
		ServiceUserCredits user1 = new ServiceUserCredits();
		try {
			
			if (user1.existMailId(mail))
			{
				logger.info("Servlet - login true");
				HttpSession session = request.getSession();
				session.setAttribute("Usermail", mail);
				logger.info(mail);
				response.sendRedirect("LoginPassword.jsp?mail="+mail+"");
			}
			else {
				String error = "UserMail Does Not Exists";
				response.sendRedirect("LoginMailId.jsp?result="+error);
				} }
			catch (ServiceException e) {
				Logger.error(e.getMessage());
			}
			}
		
	}


