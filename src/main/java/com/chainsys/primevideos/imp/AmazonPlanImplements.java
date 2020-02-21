package com.chainsys.primevideos.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.primevideos.connection.TestConnection;
import com.chainsys.primevideos.dao.AmazonPlanDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.logger.Logger;
import com.chainsys.primevideos.method.Plan;

public class AmazonPlanImplements implements AmazonPlanDAO {
	Logger logger = Logger.getInstance();

	public void addPlan(Plan plans) throws DbException {
		String sql = "insert into plans(plan_id,plan_amount,plan_duration,no_of_screens,discount_amount,originals) values (?,?,?,?,?)";
		try (Connection con = TestConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, plans.getPlanId());
			pst.setInt(2, plans.getPlanAmount());
			pst.setInt(3, plans.getPlanDuration());
			pst.setInt(4, plans.getNoOfScreens());
			pst.setInt(5, plans.getDiscountAmount());
			int row = pst.executeUpdate();
			if (row == 1) {
				logger.info("PlanId :" + plans.getPlanId() + " Inserted\n");
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.ADPLAN);

		} catch (Exception e1) {
			
			throw new DbException(InfoMessages.CONNECTION);
		}

	}

	public ArrayList<Plan> list() throws DbException {
		String sql = "select * from plans";
		try (Connection con = TestConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				ArrayList<Plan> ll = new ArrayList<>();

				while (rs.next()) {
					valPlan(rs, ll);

				}
				return ll;
			}
		}catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWPLAN);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			} 

	}

	public ArrayList<Integer> getPlanDuration(int planDuration) throws DbException {
		String sql = "select * from plans where plan_duration >= ?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, planDuration);
			try (ResultSet rs = pst.executeQuery();) {
				logger.info(rs);
				ArrayList<Integer> ln = new ArrayList<>();

				while (rs.next()) {
					int a = rs.getInt(1);

					Plan as = new Plan();
					as.setPlanId(a);

				}
				return ln;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWPLAN);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			} 
	}

	@Override
	public void deletePlan(int planId) throws DbException {
		String sql = "delete plans where plan_id = ?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, planId);
			int row = pst.executeUpdate();
			if (row == 1) {
				logger.info("PlanId :" + planId + " deleted \n");
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.DELETEPLAN);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			} 
	}

	@Override
	public void updatePlan(Plan plans) throws DbException {
		String sql = "update plans set plan_amount = ?, plan_duration = ?,no_of_screens = ?,discount_amount=? where plan_id =?";
		try (Connection con = TestConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, plans.getPlanAmount());
			pst.setInt(2, plans.getPlanDuration());
			pst.setInt(3, plans.getNoOfScreens());
			pst.setInt(4, plans.getDiscountAmount());
			pst.setInt(5, plans.getPlanId());
			int row = pst.executeUpdate();
			if (row == 1) {
				logger.info("Plan_Id :" + plans.getPlanId() + " Updated\n");
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.UPDATEPLAN);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}

	}

	public List<Plan> list1(int planId) throws DbException {
		String sql = "select * from plans where plan_id = ?";
		try (Connection con = TestConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, planId);
			try (ResultSet rs = pst.executeQuery();) {
				List<Plan> ll = new ArrayList<>();
				rs.next();
				valPlan(rs, ll);

				return ll;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWPLAN);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}

	}

	private void valPlan(ResultSet rs, List<Plan> ll) throws SQLException {
		int a = rs.getInt(1);
		int b = rs.getInt(2);
		int c = rs.getInt(3);
		int d = rs.getInt(4);
		int e = rs.getInt(5);
		Plan as = new Plan();
		as.setPlanId(a);
		as.setPlanAmount(b);
		as.setPlanDuration(c);
		as.setNoOfScreens(d);
		as.setDiscountAmount(e);

		ll.add(as);
	}
}