package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.ServiceException;
import com.chainsys.primevideos.service.ServiceUserCredits;
import com.chainsys.primevideos.util.Logger;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();
    public ChangePasswordServlet() {
        super();
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceUserCredits user = new ServiceUserCredits();
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("Usermail");
		logger.info(mail);
		String password = request.getParameter("npass");
		logger.info(password);
			try {
				if(user.updatePassword(mail, password))
				{
					RequestDispatcher dispatch = request.getRequestDispatcher("LoginMailId.jsp");
					dispatch.forward(request, response);
				}
			} catch (ServiceException e) {
				e.printStackTrace();
				response.sendRedirect("ChangePassword.jsp");
		}
	

}}
