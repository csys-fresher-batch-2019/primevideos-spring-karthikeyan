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
import com.chainsys.primevideos.model.Plan;
import com.chainsys.primevideos.service.ServicePlans;
import com.chainsys.primevideos.util.Logger;
@WebServlet("/PlanServlet")
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getInstance();
    public PlanServlet() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicePlans as = new ServicePlans();
		try {
			HttpSession session = request.getSession();
			List<Plan> list  = as.findPlans();
			logger.info(list);
			session.setAttribute("plans", list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("plan.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}

