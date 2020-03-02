package com.chainsys.primevideos.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Plan;

class AmazonPlanImplementsTest {

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
