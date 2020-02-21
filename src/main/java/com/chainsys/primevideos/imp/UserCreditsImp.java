package com.chainsys.primevideos.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.primevideos.connection.TestConnection;
import com.chainsys.primevideos.dao.UserCreditsDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.logger.Logger;
import com.chainsys.primevideos.method.UserCredits;
import com.chainsys.primevideos.util.OTPUtil;
import com.chainsys.primevideos.util.TestConformEmail;


public class UserCreditsImp implements UserCreditsDAO {
	static Logger logger = Logger.getInstance();
	public boolean userLogin(String mailID) throws DbException {
		String sql = "Select passwords from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, mailID);
		try(ResultSet rs = pst.executeQuery();){
		if (rs.next()) {
			return true;
		} else {
			logger.info("Incorrect Email ID or DoesNot Exist");
			return false;
		}}}
		catch (SQLException e1) {
			e1.printStackTrace();
			throw new DbException(InfoMessages.MAILCHECK);
		} 
		 catch (Exception e1) {
			 e1.printStackTrace();
				throw new DbException(InfoMessages.CONNECTION);
			}
		}

	
	public boolean deleteUser(String mailId) throws DbException{
		String sql ="delete from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);)
		{
			pst.setString(1, mailId);
			int row = pst.executeUpdate();
			if(row==1)
			{
			logger.info("UserCredits of :"+mailId+" deleted \n");
			return true;
			}}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.DELETEUSER);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
		return false;
	}
	

	public boolean resetPassword(String mailId) throws DbException {
		int otp = 0;
		String sql = "select * from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, mailId);
		try(ResultSet rs = pst.executeQuery();){
		if (rs.next()) {
			otp = OTPUtil.getOTP();
			TestConformEmail.changePassword(otp, mailId);
			return true;
		}
		}}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
		return false;
		
		
	}

	
	public boolean verifyOTPAndUpdatePassword(String mailId, String password) throws DbException {
		String sql1 = "update user_credits set passwords = ? where mail_id = ?"; //and otp = ?
		try(Connection con1 = TestConnection.getConnection();
		PreparedStatement pst1 = con1.prepareStatement(sql1);){
		pst1.setString(1, password);
		pst1.setString(2, mailId);
		int row = pst1.executeUpdate();
		if (row == 1) {
			logger.info("Password Updated");
			return true;
		}}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VERIFYOTP);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
		return false;

		

	}

	public boolean userSignUp(String mailId,String password) throws DbException {
		String sql = "select passwords from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, mailId);
		try(ResultSet rs = pst.executeQuery();){
		if (rs.next()) {
			logger.info("Email Id Already Exist");
			

		}/* else {
			int random = OTPUtil.getOTP();
			if(insertSignUp(mailId,password, random))
			{
				return true;
			}
			
		}*/
		}}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
		return false;

	}

	public  void insertSignUp(String mailId, String password) throws DbException {

		/*if (TestConformEmail.main(random, mailId))

		{*/
			String sql1 = "insert into user_credits (mail_id,user_id,passwords) values (?,user_id_seq.nextval,?)";
			try(Connection con1 = TestConnection.getConnection();
			PreparedStatement pst1 = con1.prepareStatement(sql1);){
			pst1.setString(1, mailId);
			pst1.setString(2, password);
			pst1.executeUpdate();
			logger.info("Welcome to Prime\nUpdate your Profile");
			
			}
			catch (SQLException e1) {
				throw new DbException(InfoMessages.MAILCHECK);
			} 
			 catch (Exception e1) {
					throw new DbException(InfoMessages.CONNECTION);
				}
			
		
		
	}
	public  boolean insertSignUp1(String name,String mailId, String password) throws DbException {
		
			String sql1 = "insert into user_credits (mail_id,customer_name,passwords) values (?,?,?)";
			try(Connection con1 = TestConnection.getConnection();
			PreparedStatement pst1 = con1.prepareStatement(sql1);){
			pst1.setString(1, mailId);
			pst1.setString(2, name);
			pst1.setString(3, password);
			pst1.executeUpdate();
			return true;
			
			}
			catch (SQLException e1) {
				throw new DbException(InfoMessages.MAILCHECK);
			} 
			 catch (Exception e1) {
					throw new DbException(InfoMessages.CONNECTION);
				}
	}

	public String password(String mailId) throws DbException {
		String sql = "Select passwords from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, mailId);
		try(ResultSet rs = pst.executeQuery();){
		rs.next();		
		return rs.getString(1);		
		}
		}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}
	public String userName(String mailId) throws DbException {
		String sql = "Select customer_name from user_credits where mail_id = ?";
		try(Connection con = TestConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, mailId);
		try(ResultSet rs = pst.executeQuery();){
		rs.next();		
		return rs.getString(1);		
		}
		}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.MAILCHECK);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}

	public void userUpdate(UserCredits users) throws DbException {
		
			String sql = "update user_credits set customer_name = ? ,gender = ?,DOB = ?,age = ?,mobile_no = ? where mail_id = ?";
			try(Connection con = TestConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);){
			pst.setString(1, users.getCustomerName());
			pst.setString(2, users.getGender());
			pst.setDate(3, Date.valueOf(users.getDob()));
			pst.setInt(4, users.getAge());
			pst.setLong(5, users.getMobileNumber());
			pst.setString(6, users.getMailId());
			int row = pst.executeUpdate();
			if (row != 0) {
				if(profile(users.getMailId()))
				{
					logger.info("Profile Updated");
				}
				else
				{
					logger.info("Profile Update Cannot Be Done");
				}
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.UPDATEUSER);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}

	public boolean profile(String mailIds) throws DbException {
		String sql1 = "select * from user_credits where mail_id = ?";
		try(Connection con1 = TestConnection.getConnection();
		PreparedStatement pst1 = con1.prepareStatement(sql1);){
		
		pst1.setString(1, mailIds);
		try(ResultSet row1 = pst1.executeQuery();){
		row1.next();
		UserCredits aes = valPrimeReleases(row1);
		logger.info(aes);
		
		}}
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWUSER);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
		return false;
	}
	private UserCredits valPrimeReleases(ResultSet row1) throws SQLException {
		String a = row1.getString(1);
		String b = row1.getString(2);
		Date c = row1.getDate(3);
		int d = row1.getInt(4);
		String e = row1.getString(5);
		int f = row1.getInt(6);
		String g = "***********";
		Long h = row1.getLong(8);
		Date i = row1.getDate(9);
		UserCredits aes = new UserCredits();
		aes.setCustomerName(a);
		aes.setGender(b);
		aes.setDob(c.toLocalDate());
		aes.setAge(d);
		aes.setMailId(e);
		aes.setUserId(f);
		aes.setPassword(g);
		aes.setMobileNumber(h);
		aes.setCreatedDate(i.toLocalDate());
		return aes;
	}
	@Override
	public List<UserCredits> list() throws DbException {
		String sql = "select * from user_credits";
		try(Connection con1 = TestConnection.getConnection();
				PreparedStatement pst1 = con1.prepareStatement(sql);){				
				try(ResultSet row1 = pst1.executeQuery();){
				ArrayList<UserCredits> ll = new ArrayList<>();
				while(row1.next())
				{
					UserCredits aes = valPrimeReleases(row1);
				ll.add(aes);
				}
				return ll;
				}
		}
				
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWUSER);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}
	public List<UserCredits> list1() throws DbException {
		String sql = "select mail_id,user_id,customer_name from user_credits";
		try(Connection con1 = TestConnection.getConnection();
				PreparedStatement pst1 = con1.prepareStatement(sql);){				
				try(ResultSet row1 = pst1.executeQuery();){
				ArrayList<UserCredits> ll = new ArrayList<>();
				while(row1.next())
				{
				String a = row1.getString(1);
				int b = row1.getInt(2);
				String c = row1.getString(3);
				UserCredits aes = new UserCredits();
				aes.setMailId(a);	
				aes.setCustomerName(c);
				aes.setUserId(b);
				ll.add(aes);
				}
				return ll;
				}
		}
				
		catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWUSER);
		} 
		 catch (Exception e1) {
				throw new DbException(InfoMessages.CONNECTION);
			}
	}

	


}
