package com.chainsys.primevideosweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.imp.UserCreditsImp;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangePasswordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCreditsImp user = new UserCreditsImp();
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("Usermail");
		String password = (String) session.getAttribute("npass");
			try {
				if(user.verifyOTPAndUpdatePassword(mail, password))
				{
					RequestDispatcher d = request.getRequestDispatcher("search.jsp");
					d.forward(request, response);
				}
			} catch (DbException e) {
				e.printStackTrace();
			}
		}
	

}