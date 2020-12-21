package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactDao {
	public int insertContact(Contact contact);

	public List<Contact> selectAllContacts();

	public Contact selectContact(int cid);

	public boolean deleteContact(int cid);

	public List<Contact> search(String str);

	public int updateContact(int cid, String email, String mobile);
}
