package com.chainsys.primevideos.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.primevideos.dao.PrimePlanDAO;
import com.chainsys.primevideos.dao.imp.PrimePlanImplements;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

@Service
public class ServicePlans {
	
	PrimePlanDAO Plans = new PrimePlanImplements();

	public ArrayList<Plan> list() throws DbException {
		return Plans.list();
	}
}
