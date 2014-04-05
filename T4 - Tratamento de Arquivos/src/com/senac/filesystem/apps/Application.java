package com.senac.filesystem.apps;

import com.senac.filesystem.contacts.FileContactsController;

public class Application 
{

	public static void main ( String args[] )
	{
		FileContactsController contactsController = new FileContactsController();
		
		contactsController.createFileContacts();  //create file.
		
		for ( int i = 0 ; i < 20 ; i++ )
			contactsController.recordContacts();   //record to file.
		
		contactsController.closeFileContacts();   //close file.
		
		System.out.println( "Operataion completed. " );
	}
	
}
