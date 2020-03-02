package com.chainsys.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.primevideos.dao.imp.AmazonPlanImplements;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

public class ServicePlans {
	@Autowired
	AmazonPlanImplements Plans;

	ArrayList<Plan> list() throws DbException {
		return Plans.list();
	}
}
