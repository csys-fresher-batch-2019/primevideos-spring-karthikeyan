package com.chainsys.primevideos.dao;

import java.util.List;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

public interface PrimePlanDAO {
	List<Plan> findPlans() throws DbException;

}
