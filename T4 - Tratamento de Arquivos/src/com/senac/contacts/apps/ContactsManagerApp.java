package com.senac.contacts.apps;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.senac.contacts.controller.ContactsManager;

public class ContactsManagerApp {

	public static void main(String[] args) {
		ContactsManager contactsManager = null;
		
		try 
		{
			contactsManager = new ContactsManager();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println( "Error file not found." );
		} 
		catch (IOException e) 
		{
			System.out.println( "Error opening file failed." );
		}
		if ( contactsManager != null)
			contactsManager.record20Contacts();
	}

}
