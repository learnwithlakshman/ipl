package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.dao.ContactDaoImpl;
import com.careerit.cbook.domain.Contact;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;

	public ContactServiceImpl() {
		contactDao = new ContactDaoImpl();
	}

	@Override
	public int addContact(String name, String email, String mobile) {
		if (name == null || name.length() == 0 || mobile == null || mobile.length() == 0) {
			throw new IllegalArgumentException("Name and mobile number can't be empty or null");
		}
		Contact contact = Contact.builder().name(name).email(email).mobile(mobile).build();
		int newId = contactDao.insertContact(contact);
		return newId;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContact(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeContact(int cid) {
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
