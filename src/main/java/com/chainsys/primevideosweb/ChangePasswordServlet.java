package com.chainsys.primevideosweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.dao.imp.UserCreditsImp;
import com.chainsys.primevideos.exception.DbException;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangePasswordServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCreditsImp user = new UserCreditsImp();
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("Usermail");
		System.out.println(mail);
		String password = request.getParameter("npass");
		System.out.println(password);
			try {
				boolean a = user.verifyOTPAndUpdatePassword(mail, password);
				if(a == true)
				{
					RequestDispatcher d = request.getRequestDispatcher("LoginMailId.jsp");
					d.forward(request, response);
				}
			} catch (DbException e) {
				e.printStackTrace();
				response.sendRedirect("ChangePassword.jsp");
				
			}
		}
	

}
