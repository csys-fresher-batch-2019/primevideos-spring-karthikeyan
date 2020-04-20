package com.chainsys.primevideos.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.primevideos.connection.ConnectionUtil;
import com.chainsys.primevideos.dao.CategoryDAO;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;
import com.chainsys.primevideos.model.Category;
import com.chainsys.primevideos.util.Logger;

@Repository
public class CategorysDAOImpl implements CategoryDAO {
	Logger logger = Logger.getInstance();

	public void saveCategorys(int id, String category) throws DbException {

		String sql = "insert into categorys (category_id,category_name) values (?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			pst.setString(2, category);
			int row = pst.executeUpdate();
			logger.info(row);
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.ADDCATEGORY, e1);
		}
	}

	public List<Category> findAllCategorys() throws DbException {

		String sql = "select category_name from categorys";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet row = pst.executeQuery();) {
				List<Category> list = new ArrayList<>();

				while (row.next()) {
					String name = row.getString("category_name");
					Category category = new Category();
					category.setCategoryName(name);
					list.add(category);
				}
				return list;
			}
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.VIEWCATEGORY, e1);
		}

	}

	public void deleteCategorys(int categoryid) throws DbException {
		String sql = "delete categorys where category_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, categoryid);
			int row = pst.executeUpdate();
			logger.info(row);
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.DELETECATEGORY, e1);
		}

	}

	public void updateCategory(int categoryid, String categoryname) throws DbException {
		String sql = "update categorys set category_name = ? where category_id = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, categoryname);
			pst.setInt(2, categoryid);
			int row = pst.executeUpdate();
			logger.info(row);
		} catch (SQLException e1) {
			throw new DbException(InfoMessages.UPDATECATEGORY, e1);
		}
	}

}