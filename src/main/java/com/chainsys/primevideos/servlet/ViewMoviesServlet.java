package com.chainsys.primevideos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeRelease;
import com.chainsys.primevideos.service.ServiceReleases;
import com.chainsys.primevideos.util.Logger;

@WebServlet("/ViewMoviesServlet")
public class ViewMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();

	public ViewMoviesServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		logger.info(id);
		int id1 = Integer.parseInt(id);
		ServiceReleases prime = new ServiceReleases();
		PrimeRelease primeReleases = new PrimeRelease();
		try {
			primeReleases = prime.findOneMovieDetails(id1);
			request.setAttribute("details", primeReleases);
			RequestDispatcher dispatcher = request.getRequestDispatcher("movie1.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e1) {
			e1.printStackTrace();
		}

	}

}
