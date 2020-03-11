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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceUserCredits user1 = new ServiceUserCredits();
		String OTP1 = (String) request.getParameter("otpuser");
		int Otp1 = Integer.parseInt(OTP1);
		HttpSession session = request.getSession();
		int OTP11 = (Integer) session.getAttribute("OTP");
		String username = (String) session.getAttribute("username");
		String mail = (String) session.getAttribute("MailIdRegister");
		String password = (String) session.getAttribute("PasswordRegister");
		if (Otp1 == OTP11) {
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