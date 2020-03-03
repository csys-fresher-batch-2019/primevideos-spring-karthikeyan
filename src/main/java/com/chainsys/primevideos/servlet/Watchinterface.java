package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.service.ServiceWatchList;

@WebServlet("/Watchinterface")
public class Watchinterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Watchinterface() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String decides = (String) request.getParameter("decide");
		int decide = Integer.parseInt(decides);
		String mailid = (String) session.getAttribute("Usermail");
		String prime = (String) request.getParameter("movieid");
		String moviename = (String) request.getParameter("movien");
		System.out.println(decides);
		System.out.println(mailid);
		System.out.println(prime);
		System.out.println(moviename);
		int primeid = Integer.parseInt(prime);
		//WatchListDAOImp as = new WatchListDAOImp();
		ServiceWatchList as = new ServiceWatchList();
		if (decide == 1) {

			try {
				boolean result = as.updateWatched(mailid, primeid, 1);
				System.out.println("Result:" + result);
				if (result) {
					response.sendRedirect("Video.jsp?movieid=" + prime + "&movien=" + moviename);
				} else {
					response.sendRedirect("ViewMoviesServlet?id=" + prime);
				}
			} catch (DbException e) {

				e.printStackTrace();
			}

		} else if (decide == 2) {

			try {
				boolean result = as.updateWatched(mailid, primeid, 2);
				System.out.println("Result:" + result);
				if (result) {
					response.sendRedirect("ViewMoviesServlet?id=" + prime);
				} else {
					response.sendRedirect("ViewMoviesServlet?id=" + prime);
				}
			} catch (DbException e) {

				e.printStackTrace();
			}
		}
	}

}
