package com.chainsys.primevideos.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.PrimePlanImplements;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

@RestController
@RequestMapping("api")
public class PlanController {

	@GetMapping("/primeplans")
	public ArrayList<Plan> list() throws DbException, ClassNotFoundException {
		PrimePlanImplements plan = new PrimePlanImplements();
		ArrayList<Plan> plans = new ArrayList<>();
		plans = plan.list();
		return plans;
	}

}
