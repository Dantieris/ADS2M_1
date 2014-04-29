package com.senac.contacts.apps;

import com.senac.contacts.controller.ContactsManager;

public class ContactsManagerApp {

	public static void main(String[] args) {
		ContactsManager contactsManager = new ContactsManager();
		
		contactsManager.record20Contacts();
	}

}
