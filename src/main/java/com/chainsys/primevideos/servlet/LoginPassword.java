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
@WebServlet("/LoginPassword")
public class LoginPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginPassword() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("Usermail");
		String password = request.getParameter("password");
		System.out.println(mail);
		System.out.println(password);
		//UserCreditsImp user1 = new UserCreditsImp();
		ServiceUserCredits user1 = new ServiceUserCredits();
		try {
			String Pass = user1.findUserPassword(mail);
			if (Pass.equals(password))
			{
				String username = user1.findUserName(mail);
				session.setAttribute("username", username);
				session.setAttribute("Usermail",mail);
				System.out.println(username);
				response.sendRedirect("Index1.jsp");
			}
			else
			{
				String error = "Incorrect Password";
				response.sendRedirect("LoginPassword.jsp?result="+error);
			}
		}
		catch (DbException e) {
			Logger.error(e.getMessage());
		}
	}

}
