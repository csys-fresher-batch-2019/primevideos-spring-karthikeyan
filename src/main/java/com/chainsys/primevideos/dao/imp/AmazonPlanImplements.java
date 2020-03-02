package com.chainsys.primevideos.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.TestConnection;
import com.chainsys.primevideos.dao.AmazonPlanDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.logger.Logger;
import com.chainsys.primevideos.model.Plan;
@Repository
public class AmazonPlanImplements implements AmazonPlanDAO {
	Logger logger = Logger.getInstance();
	public ArrayList<Plan> list() throws DbException {
		String sql = "select * from plans";
		try (Connection con = TestConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				ArrayList<Plan> ll = new ArrayList<>();

				while (rs.next()) {
					valPlan(rs, ll);

				}
				return ll;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWPLAN);
		} catch (Exception e1) {
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