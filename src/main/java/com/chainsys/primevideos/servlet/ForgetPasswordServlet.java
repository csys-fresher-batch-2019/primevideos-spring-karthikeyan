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

@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ForgetPasswordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("email");		
		ServiceUserCredits user1 = new ServiceUserCredits();		
		try {
			boolean a = user1.userLogin(mail);
			if (a == true)
			{
				HttpSession session = request.getSession();
				int otp = OTPUtil.getOTP();	
				session.setAttribute("OTPass", otp);
				session.setAttribute("Usermail", mail);
				TestConformEmail.otpjsp(otp, mail);
				RequestDispatcher d = request.getRequestDispatcher("OTPassword.jsp");
				d.forward(request, response);
				
			}
			else {
				String error = "UserMail Does Not Exists";
				response.sendRedirect("ForgetPassword.jsp?result="+error);
				} }
			catch (DbException e) {
				Logger.error(e.getMessage());
			}
			}
	}


