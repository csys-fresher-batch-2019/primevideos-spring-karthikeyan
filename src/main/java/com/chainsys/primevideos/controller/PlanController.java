package com.chainsys.primevideos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.PrimePlanDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

@RestController
@RequestMapping("api")
public class PlanController {

	@GetMapping("/primeplans")
	public List<Plan> primePlans() throws DbException, ClassNotFoundException {
		PrimePlanDAOImpl plan = new PrimePlanDAOImpl();
		List<Plan> plans = new ArrayList<>();
		plans = plan.findPlans();
		return plans;
	}

}
