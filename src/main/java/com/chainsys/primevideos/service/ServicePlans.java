package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimePlanDAO;
import com.chainsys.primevideos.dao.imp.PrimePlanDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

@Service
public class ServicePlans {

	private PrimePlanDAO Plans = new PrimePlanDAOImpl();

	public ArrayList<Plan> findPlans() throws DbException {
		return Plans.findPlans();
	}
}
