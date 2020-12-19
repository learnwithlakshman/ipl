package com.lwl.jdbcexamples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public enum DbConnectionUtil {
	util;

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(DbConnectionUtil.class.getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			System.out.println("While loading properites file :" + e);
		}
	}
	
	public Connection getConnectionMySQl() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(properties.getProperty("mysql.url"), properties.getProperty("mysql.username"),
					properties.getProperty("mysql.password"));
		} catch (SQLException e) {
			System.out.println("While connecting with database :" + e);
		}
		return con;
	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resource :" + e);
		}
	}
}
