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
import com.chainsys.primevideos.util.Logger;

@WebServlet("/Watchinterface")
public class Watchinterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION = "ViewMoviesServlet?id=";  
	static Logger logger = Logger.getInstance();
	public Watchinterface() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String decides = request.getParameter("decide");
		int decide = Integer.parseInt(decides);
		String mailid = (String) session.getAttribute("Usermail");
		String prime = request.getParameter("movieid");
		String moviename = request.getParameter("movien");
		int primeid = Integer.parseInt(prime);
		ServiceWatchList as = new ServiceWatchList();
		if (decide == 1) {

			try {
				boolean result = as.updateWatched(mailid, primeid, 1);
				logger.info("Result:" + result);
				if (result) {
					response.sendRedirect("Video.jsp?movieid=" + prime + "&movien=" + moviename);
				} else {
					response.sendRedirect(ACTION + prime);
				}
			} catch (DbException e) {

				e.printStackTrace();
			}

		} else if (decide == 2) {

			try {
				boolean result = as.updateWatched(mailid, primeid, 2);
				logger.info("Result:" + result);
				if (result) {
					response.sendRedirect(ACTION + prime);
				} else {
					response.sendRedirect(ACTION + prime);
				}
			} catch (DbException e) {

				e.printStackTrace();
			}
		}
	}

}
