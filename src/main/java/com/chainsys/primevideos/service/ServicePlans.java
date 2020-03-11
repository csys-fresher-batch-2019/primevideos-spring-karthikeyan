package com.chainsys.primevideos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimePlanDAO;
import com.chainsys.primevideos.dao.imp.PrimePlanDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

@Service
public class ServicePlans {

	PrimePlanDAO plans = new PrimePlanDAOImpl();

	public List<Plan> findPlans() throws DbException {
		return plans.findPlans();
	}
}
