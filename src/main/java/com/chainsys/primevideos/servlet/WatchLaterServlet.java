package com.chainsys.primevideos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;
import com.chainsys.primevideos.service.ServiceWatchList;
@WebServlet("/WatchLaterServlet")
public class WatchLaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WatchLaterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("Usermail");		
		ServiceWatchList wa = new ServiceWatchList();
		List<PrimeRelease> list ;
		try {
			list =  wa.findOneWatchLater(mail);
			System.out.println(list);
			session.setAttribute("watchlatermovies", list);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("Mymovies.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e1) {
			e1.printStackTrace();
		}
	}

}
