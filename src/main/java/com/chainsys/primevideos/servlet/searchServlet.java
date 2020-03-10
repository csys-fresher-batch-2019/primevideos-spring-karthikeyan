package com.chainsys.primevideos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.PrimeReleases;
import com.chainsys.primevideos.service.ServiceReleases;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public searchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrimeReleasesDAOImp a = new PrimeReleasesDAOImp();
		ServiceReleases a = new ServiceReleases();
		PrimeReleases as = new PrimeReleases();
		List<PrimeReleases> list = new ArrayList<PrimeReleases>();
		String term = request.getParameter("searchterm");
		String category = request.getParameter("categorys");
		int categorys = Integer.parseInt(category);
		String genre = request.getParameter("genre");
		String imdbratings = request.getParameter("imdbrating");
		int imdbrating = Integer.parseInt(imdbratings);
		String language = request.getParameter("language");
		String director = request.getParameter("Director");
		String actor = request.getParameter("Actor");
		String original = request.getParameter("originals");
		boolean originals = false;
		if (original == "on") {
			originals = true;
		}
		as.setNameofVideo(term);
		as.setCategoryId(categorys);
		as.setGenre(genre);
		as.setImdbRating(imdbrating);
		as.setAudioLanguages(language);
		as.setDirector(director);
		as.setCasting(actor);
		as.setOriginals(originals);
		try {
			list = a.findMoviesSearch(as);
			request.setAttribute("movies", list);
			RequestDispatcher rd = request.getRequestDispatcher("demo.jsp");
			rd.forward(request, response);
		} catch (DbException e) {

			e.printStackTrace();
		}

	}
}