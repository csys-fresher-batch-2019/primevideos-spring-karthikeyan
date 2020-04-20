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
@WebServlet("/LoginPassword")
public class LoginPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();
    public LoginPassword() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("Usermail");
		String password = request.getParameter("password");
		logger.info(mail);
		logger.info(password);
		ServiceUserCredits user1 = new ServiceUserCredits();
		try {
			String pass = user1.findUserPassword(mail);
			if (pass.equals(password))
			{
				String username = user1.findUserName(mail);
				session.setAttribute("username", username);
				session.setAttribute("Usermail",mail);
				logger.info(username);
				response.sendRedirect("Index1.jsp");
			}
			else
			{
				String error = "Incorrect Password";
				response.sendRedirect("LoginPassword.jsp?result="+error);
			}
		}
		catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
	}

}
