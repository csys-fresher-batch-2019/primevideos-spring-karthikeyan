package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/OTPassword")
public class OTPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OTPassword() {
        super();
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp1 = request.getParameter("otpuserpass");
		int otp2 = Integer.parseInt(otp1);
		HttpSession session = request.getSession();
		int otp3 = (Integer) session.getAttribute("OTPass");
	if (otp2 == otp3)
	{ 
		RequestDispatcher dispatch = request.getRequestDispatcher("ChangePassword.jsp");
		dispatch.forward(request, response);		
			
		
	}
	else
	{
		String error = "OTP Does Not Match";
		response.sendRedirect("OTPassword.jsp?result1="+error);
		
	}
}

}
