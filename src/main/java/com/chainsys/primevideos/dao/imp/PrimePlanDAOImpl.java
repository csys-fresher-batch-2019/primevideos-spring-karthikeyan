package com.chainsys.primevideos.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.ConnectionUtil;
import com.chainsys.primevideos.dao.PrimePlanDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.model.Plan;
import com.chainsys.primevideos.util.Logger;

@Repository
public class PrimePlanDAOImpl implements PrimePlanDAO {
	Logger logger = Logger.getInstance();

	public List<Plan> findPlans() throws DbException {
		String sql = "select plan_id,plan_amount,plan_duration,no_of_screens,discount_amount from plans";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				List<Plan> list = new ArrayList<>();

				while (rs.next()) {
					int id = rs.getInt("plan_id");
					int amount = rs.getInt("plan_amount");
					int duration = rs.getInt("plan_duration");
					int screens = rs.getInt("no_of_screens");
					int discount = rs.getInt("discount_amount");
					Plan plan = new Plan();
					plan.setPlanId(id);
					plan.setPlanAmount(amount);
					plan.setPlanDuration(duration);
					plan.setNoOfScreens(screens);
					plan.setDiscountAmount(discount);

					list.add(plan);

				}
				return list ;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWPLAN,e1);
		}
	}

}