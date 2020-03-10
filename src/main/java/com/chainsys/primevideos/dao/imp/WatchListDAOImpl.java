package com.chainsys.primevideos.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.TestConnection;
import com.chainsys.primevideos.dao.WatchListDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.model.PrimeReleases;
import com.chainsys.primevideos.util.Logger;

@Repository
public class WatchListDAOImpl implements WatchListDAO {
	static Logger logger = Logger.getInstance();

	public void saveLikes(String mailId, int primeId) throws DbException {
		boolean row = false;
		try (Connection con = TestConnection.getConnection();
				CallableStatement cstmt = con.prepareCall("{call LIKES(?,?)}");) {
			cstmt.setString(1, mailId);
			cstmt.setInt(2, primeId);
			row = cstmt.execute();
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.OPERATION);
		}
		if (row == true)
			System.out.println("Thanks for your Review");
	}

	public void saveDislikes(String mailId, int primeId) throws DbException {
		boolean row = false;
		try (Connection con = TestConnection.getConnection();
				CallableStatement cstmt = con.prepareCall("{call DISLIKES(?,?)}");) {
			cstmt.setString(1, mailId);
			cstmt.setInt(2, primeId);
			row = cstmt.execute();
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.OPERATION);
		}
		if (row == true)
			System.out.println("Thanks for your Review");
	}

	public void saveViewerRating(String mailId, int primeId, int viewerRating) throws DbException {
		boolean row = false;
		try (Connection con = TestConnection.getConnection();
				CallableStatement cstmt = con.prepareCall("{call VIEWER_REIVEW(?,?,?)}");) {
			cstmt.setInt(3, viewerRating);
			cstmt.setString(1, mailId);
			cstmt.setInt(2, primeId);
			row = cstmt.execute();
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.OPERATION);
		}
		if (row == true)
			System.out.println("Thanks for your Review");
	}

	public boolean updateWatched(String mailId, int primeId, int decide) throws DbException {
		boolean row;
		if (findAllWatched(mailId, primeId)) {
			try (Connection con = TestConnection.getConnection();
					CallableStatement cstmt = con.prepareCall("{call INCREMENT_WATCHED_BY_ONE(?,?,?)}");) {
				System.out.println("hello123");
				cstmt.setString(1, mailId);
				cstmt.setInt(2, primeId);
				cstmt.setInt(3, decide);
				row = cstmt.execute();
				if (row == false) {
					System.out.println("Enjoy PRIME VIDEOS");
					return true;
				}
			} catch (SQLException e1) {
				throw new DbException(InfoMessages.OPERATION);
			}

		} else {
			String sql2 = "";
			if (decide == 1) {
				sql2 = "insert into  watch_lists (watched,mail_id,prime_id) values (1,?,?)";
			} else {
				sql2 = "insert into  watch_lists (watch_later,mail_id,prime_id) values (1,?,?)";
			}
			try (Connection con = TestConnection.getConnection(); 
					PreparedStatement pst = con.prepareStatement(sql2);) {
				pst.setString(1, mailId);
				pst.setInt(2, primeId);
				try (ResultSet rs = pst.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DbException(InfoMessages.MAILCHECK);
			}
		}
		return false;
	}

	public ArrayList<PrimeReleases> findOneWatched(String MailId) throws DbException {
		String sql = "select prime_id,name_of_video from prime_releases where prime_id IN (select prime_id from watch_lists where mail_id = ? and watched <> 0)";
		try (Connection con = TestConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, MailId);
			try (ResultSet rs = pst.executeQuery();) {
				ArrayList<PrimeReleases> l = new ArrayList<>();
				while (rs.next()) {
					PrimeReleases at = new PrimeReleases();
					int a = rs.getInt(1);
					String b = rs.getString(2);
					at.setPrimeId(a);
					at.setNameofVideo(b);
					l.add(at);
				}
				return l;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO);
		}
	}

	public ArrayList<PrimeReleases> findOneWatchLater(String MailId) throws DbException {
		String sql = "select prime_id,name_of_video from prime_releases where prime_id IN (select prime_id from watch_lists where mail_id = ? and watch_later <> 0)";
		try (Connection con = TestConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, MailId);
			try (ResultSet rs = pst.executeQuery();) {
				ArrayList<PrimeReleases> l = new ArrayList<>();
				while (rs.next()) {
					PrimeReleases at = new PrimeReleases();
					int a = rs.getInt(1);
					String b = rs.getString(2);
					at.setPrimeId(a);
					at.setNameofVideo(b);
					l.add(at);
				}
				return l;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWVIDEO);
		}
	}

	public boolean findAllWatched(String mailID, int primeId) throws DbException {
		String sql = "Select * from watch_lists where mail_id = ? and prime_id = ?";
		try (Connection con = TestConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mailID);
			pst.setInt(2, primeId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DbException(InfoMessages.MAILCHECK);
		}
	}

}
