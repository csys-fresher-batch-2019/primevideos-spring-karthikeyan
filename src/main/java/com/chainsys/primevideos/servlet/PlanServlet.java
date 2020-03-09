package com.chainsys.primevideos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;
import com.chainsys.primevideos.service.ServicePlans;
@WebServlet("/PlanServlet")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlanServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicePlans as = new ServicePlans();
		try {
			HttpSession session = request.getSession();
			ArrayList<Plan> list  = as.list();
			System.out.println(list);
			session.setAttribute("plans", list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("plan.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}

