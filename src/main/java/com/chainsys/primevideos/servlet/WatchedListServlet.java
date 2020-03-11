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
@WebServlet("/WatchedListServlet")
public class WatchedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WatchedListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mail = (String)session.getAttribute("Usermail");		
		//WatchListDAOImp wa = new WatchListDAOImp();
		ServiceWatchList wa = new ServiceWatchList();
		List<PrimeRelease> list ;
		try {
			list =  wa.findOneWatched(mail);
			System.out.println(list);
			request.setAttribute("watchedmovies", list);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("watched.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e1) {
			e1.printStackTrace();
		}
	}

}
