package com.chainsys.primevideos.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.imp.AmazonPlanImplements;
import com.chainsys.primevideos.model.Plan;

class PlanUnit {

	@Test
	void testDisplayPlan() throws DbException {
				Plan plans = new Plan();
				AmazonPlanImplements plan = new AmazonPlanImplements();
				ArrayList<Plan> expected = new ArrayList();
				Plan planss = new Plan();
				planss.setPlanId(100);
				planss.setPlanDuration(500);
				planss.setPlanAmount(1500);
				planss.setNoOfScreens(4);
				planss.setDiscountAmount(50);
				expected.add(planss);
				ArrayList<Plan> actual = new ArrayList();
				actual = plan.list();
				assertEquals(expected,actual);
			}

		}
	


