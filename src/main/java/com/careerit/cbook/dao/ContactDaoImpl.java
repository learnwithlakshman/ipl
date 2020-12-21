package com.careerit.cbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.careerit.cbook.dao.util.DbConnectionUtil;
import com.careerit.cbook.domain.Contact;

public class ContactDaoImpl implements ContactDao {

	private DbConnectionUtil conUtil = DbConnectionUtil.util;

	private final static String ADD_CONTACT = "insert into contact(name,email,mobile) values(?,?,?)";
	private final static String ALL_CONTACTS = "select cid,name,email,mobile from contact";

	@Override
	public int insertContact(Contact contact) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int key = -1;
		try {
			con = conUtil.getConnectionMySQl();
			pst = con.prepareStatement(ADD_CONTACT,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getMobile());
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			if(rs.first()) {
				key = rs.getInt(1);
			}
		}catch (SQLException e) {
			System.out.println("While adding contact : "+e);
		}finally {
			conUtil.close(rs, pst, con);
		}
		
		return key;
	}

	@Override
	public List<Contact> selectAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact selectContact(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contact> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateContact(int cid, String email, String mobile) {
		// TODO Auto-generated method stub
		return 0;
	}

}
