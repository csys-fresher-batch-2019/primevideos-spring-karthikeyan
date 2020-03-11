package com.chainsys.primevideos.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.ConnectionUtil;
import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.util.Logger;

@Repository
public class UserCreditsDAOImpl implements UserCreditsDAO {
	static Logger logger = Logger.getInstance();

	public boolean existMailId(String mailID) throws DbException {
		String sql = "Select passwords from user_credits where mail_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mailID);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					logger.info("Incorrect Email ID or DoesNot Exist");
					return false;
				}
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK,e1);
		}
	}

	/** verify the OTP and update the new changed password **/
	public boolean updatePassword(String mailId, String password) throws DbException {
		String sql1 = "update user_credits set passwords = ? where mail_id = ?"; // and otp = ?
		try (Connection con1 = ConnectionUtil.getConnection(); PreparedStatement pst1 = con1.prepareStatement(sql1);) {
			pst1.setString(1, password);
			pst1.setString(2, mailId);
			int row = pst1.executeUpdate();
			if (row == 1) {
				logger.info("Password Updated");
				return true;
			}else
			{
				return false;	
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VERIFYOTP,e1);
		}
		

	}

	public boolean saveUserSignUp(String name, String mailId, String password) throws DbException {

		String sql1 = "insert into user_credits (mail_id,customer_name,passwords) values (?,?,?)";
		try (Connection con1 = ConnectionUtil.getConnection(); PreparedStatement pst1 = con1.prepareStatement(sql1);) {
			pst1.setString(1, mailId);
			pst1.setString(2, name);
			pst1.setString(3, password);
			pst1.executeUpdate();
			return true;

		} catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK,e1);
		}
	}

	public String findUserPassword(String mailId) throws DbException {
		String sql = "Select passwords from user_credits where mail_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mailId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					return rs.getString(1);
				}
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK,e1);
		}
		return null;
	}

	public String findUserName(String mailId) throws DbException {
		String sql = "Select customer_name from user_credits where mail_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mailId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					return rs.getString(1);
				}
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK,e1);
		}
		return null;
	}

}
