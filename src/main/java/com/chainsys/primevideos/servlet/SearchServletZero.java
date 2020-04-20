package com.chainsys.primevideos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.primevideos.exception.ServiceException;
import com.chainsys.primevideos.model.Category;
import com.chainsys.primevideos.model.PrimeRelease;
import com.chainsys.primevideos.service.ServiceCategory;
import com.chainsys.primevideos.service.ServiceReleases;
import com.chainsys.primevideos.util.Logger;

@WebServlet("/SearchServletZero ")
public class SearchServletZero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();

	public SearchServletZero() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceReleases release = new ServiceReleases();
		ServiceCategory category = new ServiceCategory();
		List<PrimeRelease> list ;
		List<PrimeRelease> list1 ;
		List<PrimeRelease> list2 ;
		List<Category> list3;
		try {
			list = release.findlanguages();
			list1 = release.findImdbRating();
			list2 = release.findGenres();
			list3 = category.findAllCategorys();
			logger.info(list);
			logger.info(list2);
			request.setAttribute("languages", list);
			request.setAttribute("imdb", list1);
			request.setAttribute("genre", list2);
			request.setAttribute("category", list3);
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
			
		} 	catch (ServiceException e) {
			Logger.error(e.getMessage());
		}

	}
}
