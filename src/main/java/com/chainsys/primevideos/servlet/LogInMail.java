package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.service.ServiceUserCredits;
import com.chainsys.primevideos.util.Logger;
@WebServlet("/LogInMail")
public class LogInMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogInMail() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("email");		
		//UserCreditsImp user1 = new UserCreditsImp();
		ServiceUserCredits user1 = new ServiceUserCredits();
		try {
			boolean a = user1.userLogin(mail);
			System.out.println("Servlet - login" + a);
			if (a == true)
			{
				HttpSession session = request.getSession();
				session.setAttribute("Usermail", mail);
				System.out.println(mail);
				response.sendRedirect("LoginPassword.jsp?mail="+mail+"");
			}
			else {
				String error = "UserMail Does Not Exists";
				response.sendRedirect("LoginMailId.jsp?result="+error);
				} }
			catch (DbException e) {
				Logger.error(e.getMessage());
			}
			}
		
	}


