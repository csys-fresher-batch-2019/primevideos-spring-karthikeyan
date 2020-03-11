package com.chainsys.primevideos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.exception.InfoMessages;

@Component
public class ConnectionUtil {
	private ConnectionUtil() {
	}

	public static Connection getConnection() throws DbException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
			connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "karthikeyan","karthikeyan");
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
			
		}

		return connection;

	}
}
