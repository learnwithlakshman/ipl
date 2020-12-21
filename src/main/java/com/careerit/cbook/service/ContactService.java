package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactService {

		public int addContact(String name,String email,String mobile);
		public List<Contact> getAllContacts();
		public Contact getContact(int cid);
		public boolean removeContact(int cid);
		public List<Contact> search(String str);
		public int updateContact(int cid, String email,String mobile);
}
