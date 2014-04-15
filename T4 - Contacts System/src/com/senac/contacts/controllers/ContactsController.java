package com.senac.contacts.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.senac.PraticaOOP.Controler;
import com.senac.contacts.files.FileContacts;

public class ContactsController 
{
	FileContacts contactsList = null;
	Controler contactGenerator = null;
	
	public ContactsController()
	{
		contactsList 		= new FileContacts();
		contactGenerator 	= new Controler();
	}
	
	//create contacts.txt file.
	public void createFile()
	{
		Path path = Paths.get(System.getProperty( "user.home" ), "contacts.txt");
		contactsList.createFile( path.toString() );
	}
	
	//close file.
	public void saveFile()
	{
		contactsList.closeFile();
	}
	
	//record on file.
	public void recordContacts()
	{
		String name 	= contactGenerator.gerarNomeAleatorio();
		String address 	= contactGenerator.gerarEnderecoAleatorio();
		String phone 	= contactGenerator.gerarTelefoneAleatorio();
		
		contactsList.saveContacts(name, address, phone);
	}
	
	//record 20 contacts on file.
	public void recordListContacts()
	{
		for ( int i = 0 ; i < 20 ; i++ )
		{
			recordContacts();
		}
	}
	
}
