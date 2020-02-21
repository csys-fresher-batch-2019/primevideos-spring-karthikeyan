package com.chainsys.primevideos.dao;

import java.util.ArrayList;



import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.method.Plan;

public interface AmazonPlanDAO {
	
	void addPlan(Plan plans) throws DbException;
	void deletePlan(int planId) throws DbException;
	void updatePlan(Plan plans) throws DbException;
	ArrayList<Plan> list() throws DbException;
	ArrayList<Integer> getPlanDuration(int planDuration) throws DbException;
	
	


}
