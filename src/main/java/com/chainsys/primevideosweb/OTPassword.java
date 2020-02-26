package com.chainsys.primevideosweb;

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
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OTP1 = (String) request.getParameter("otpuserpass");
		int Otp1 = Integer.parseInt(OTP1);
		HttpSession session = request.getSession();
		int OTP11 = (Integer) session.getAttribute("OTPass");
	if (Otp1 == OTP11)
	{ 
		RequestDispatcher d = request.getRequestDispatcher("ChangePassword.jsp");
		d.forward(request, response);		
			
		
	}
	else
	{
		String error = "OTP Does Not Match";
		response.sendRedirect("OTPassword.jsp?result1="+error);
		
	}
}

}
