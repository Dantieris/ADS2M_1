package com.sena.contacts.apps;

import com.senac.contacts.controllers.ContactsController;

public class Application 
{
	public static void main ( String args[] )
	{
		ContactsController contactsManagement = new ContactsController();
		
		contactsManagement.createFile();  //create file.
		contactsManagement.recordListContacts(); //record 20 contacts on file.
		contactsManagement.saveFile();  //close/save file.
		
		System.out.println( "Operation Completed" );
	}
}
