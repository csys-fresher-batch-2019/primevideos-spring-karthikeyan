package com.chainsys.primevideos.dao;

import java.util.ArrayList;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

public interface AmazonPlanDAO {
	ArrayList<Plan> list() throws DbException;

}
