package com.chainsys.primevideos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;
import com.chainsys.primevideos.service.ServiceReleases;

@WebServlet("/ViewMoviesServlet")
public class ViewMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewMoviesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("hello");
		System.out.println(id);
		int id1 = Integer.parseInt(id);
		ServiceReleases prime = new ServiceReleases();
		PrimeReleases primeReleases = new PrimeReleases();
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
