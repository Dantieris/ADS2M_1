package com.senac.filesystem.apps;

import com.senac.filesystem.bankaccounts.BankAccountsController;
import com.senac.filesystem.bankaccounts.FileAccounts;
import com.senac.filesystem.contacts.FileContactsController;

public class Application 
{

	public static void main ( String args[] )
	{		
		fileContactsCreation();
		
		FileAccounts bankAccount 				= new FileAccounts();
		BankAccountsController bankController 	= new BankAccountsController();
		
		bankController.readContacts();
		
	}
	
	//create contacts.txt file and add 20 contacts randomly.
	public static void fileContactsCreation()
	{
		FileContactsController contactsController = new FileContactsController();
		
		contactsController.createFileContacts();  //create file.
		
		for ( int i = 0 ; i < 20 ; i++ )
			contactsController.recordContacts();   //record to file.
		
		contactsController.closeFileContacts();   //close file.
		
		System.out.println( "Operataion completed. " );
	}
}
