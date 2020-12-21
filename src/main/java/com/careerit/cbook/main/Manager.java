package com.careerit.cbook.main;

import com.careerit.cbook.service.ContactService;
import com.careerit.cbook.service.ContactServiceImpl;

public class Manager {

	public static void main(String[] args) {

		
		// Menu
		ContactService contactService = new ContactServiceImpl();
		
		int id = contactService.addContact("Charan", "charan@gmail.com", "9876543211");
		System.out.println(id);
		
	}
}
