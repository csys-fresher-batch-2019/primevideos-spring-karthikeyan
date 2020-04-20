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

@WebServlet("/OtpServlet")
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OtpServlet() {
		super();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceUserCredits user1 = new ServiceUserCredits();
		String otp1 = request.getParameter("otpuser");
		int otp2 = Integer.parseInt(otp1);
		HttpSession session = request.getSession();
		int otp3 = (Integer) session.getAttribute("OTP");
		String username = (String) session.getAttribute("username");
		String mail = (String) session.getAttribute("MailIdRegister");
		String password = (String) session.getAttribute("PasswordRegister");
		if (otp2 == otp3) {
			try {
				boolean result = user1.saveUserSignUp(username, mail, password);
				if (result) {
					RequestDispatcher dispatch = request.getRequestDispatcher("Index1.jsp");
					dispatch.forward(request, response);
				}
			} catch (ServiceException e) {
				Logger.error(e.getMessage());
			} 

		} else {
			String error = "OTP Does Not Match";
			response.sendRedirect("OTP.jsp?result1=" + error);

		}

	}
}