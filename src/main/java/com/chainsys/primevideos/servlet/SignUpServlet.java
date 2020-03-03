package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.service.ServiceUserCredits;
import com.chainsys.primevideos.util.Logger;
import com.chainsys.primevideos.util.OTPUtil;
import com.chainsys.primevideos.util.TestConformEmail;
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SignUpServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String mail=request.getParameter("email");
		String password = request.getParameter("npass");
		ServiceUserCredits user1 = new ServiceUserCredits();
		try {
			boolean a = user1.userLogin(mail);
			System.out.println("Servlet - login" + a);
			if (a == true)
			{
				String error = "User Mail Already Exists";
				response.sendRedirect("Register.jsp?result="+error);
			}
			else {
				HttpSession session = request.getSession();
				int otp = OTPUtil.getOTP();	
				session.setAttribute("OTP", otp);
				session.setAttribute("username", username);
				session.setAttribute("MailIdRegister", mail);
				session.setAttribute("PasswordRegister", password);
				TestConformEmail.otpjsp(otp, mail);
				RequestDispatcher d = request.getRequestDispatcher("OTP.jsp");
				d.forward(request, response);		
				} }
			catch (DbException e) {
				Logger.error(e.getMessage());
			}
			}

	}

