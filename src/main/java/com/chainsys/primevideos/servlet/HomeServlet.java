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

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrimeReleasesDAOImp Imp = new PrimeReleasesDAOImp();
		ServiceReleases Imp = new ServiceReleases();
		ArrayList<PrimeReleases> list1 = new ArrayList<PrimeReleases>();
		ArrayList<PrimeReleases> lists = new ArrayList<PrimeReleases>();
		try 
		{
			list1 = Imp.list2();
			request.setAttribute("imdbslide",list1);
			lists = Imp.list3();
			request.setAttribute("oriimdbslide",lists);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request,response);
		}
	 catch (DbException e) {
		
		e.printStackTrace();
	}
		

}
}