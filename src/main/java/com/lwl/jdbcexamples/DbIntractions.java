package com.lwl.jdbcexamples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DbIntractions {

	public void deleteProduct(String pname) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		final String DELET_PRODUT = "delete from product where pname = ?";

		try {
			con = DbConnectionUtil.util.getConnectionMySQl();
			st = con.prepareStatement(DELET_PRODUT);
			st.setString(1, pname);
			int count = st.executeUpdate();
			System.out.println("No of products deleted is :" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnectionUtil.util.close(rs, st, con);
		}

	}

	public void totalSalaryOf(String dname) {
		Connection con = null;
		CallableStatement st = null;
		ResultSet rs = null;

		try {
			con = DbConnectionUtil.util.getConnectionMySQl();
			st = con.prepareCall("{call total_sal(?,?)}");

			st.setString(1, dname);

			st.registerOutParameter(1, Types.VARCHAR);
			st.registerOutParameter(2, Types.FLOAT);

			st.execute();
			
			String deptName = st.getString(1);
			float tsal = st.getFloat(2);
			System.out.println(deptName + " " + tsal);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnectionUtil.util.close(rs, st, con);
		}
	}

	public void addProduct(String pname, float price) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		final String ADD_PRODUCT = "insert into product(pname,price) values(?,?)";

		try {
			con = DbConnectionUtil.util.getConnectionMySQl();
			st = con.prepareStatement(ADD_PRODUCT);
			st.setString(1, pname);
			st.setFloat(2, price);
			int count = st.executeUpdate();
			System.out.println("No of records inserted is :" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnectionUtil.util.close(rs, st, con);
		}

	}

	// Display empno, ename, deptno, salary of all the employees
	public void showEmpDetails() {

		final String GET_DEPT_DETAILS = "select empno,ename,deptno,sal from emp";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DbConnectionUtil.util.getConnectionMySQl();
			st = con.createStatement();
			rs = st.executeQuery(GET_DEPT_DETAILS);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				String deptno = rs.getString("deptno");
				float salary = rs.getFloat("sal");
				System.out.println(String.format("%s -  %s -  %s - %s", empno, name, deptno, salary));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnectionUtil.util.close(rs, st, con);
		}

	}

	public void showDeptDetails() {
		// Connection parameters

		final String GET_DEPT_DETAILS = "select dname,location,deptno from dept";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DbConnectionUtil.util.getConnectionMySQl();
			st = con.createStatement();
			rs = st.executeQuery(GET_DEPT_DETAILS);
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("location");
				System.out.println(String.format("%s -  %s -  %s", deptno, dname, loc));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnectionUtil.util.close(rs, st, con);
		}

	}
}
