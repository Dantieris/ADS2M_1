package com.senac.filesystem.contacts;

import com.senac.PraticaOOP.Controler;

public class FileContactsController
{
	private FileContacts contacts = null;
	private Controler contactsGenerator = null;
	
	//constructor.
	public FileContactsController()
	{
		contacts  			= new FileContacts();
		contactsGenerator	= new Controler();
	}
	
	//returns contacts.
	public FileContacts getContacts()
	{
		return contacts;
	}
	
	//create the contacts.txt file.
	public void createFileContacts()
	{
		contacts.createFile();
	}
	
	//close the contacts.txt file.
	public void closeFileContacts()
	{
		contacts.closeFile();
	}
	
	//generate and record a random contacts to file.
	public void recordContacts()
	{
		String name 	= null;
		String address 	= null;
		String phone 	= null;
		
		name 	= contactsGenerator.gerarNomeAleatorio();
		address = contactsGenerator.gerarEnderecoAleatorio();
		phone 	= contactsGenerator.gerarTelefoneAleatorio();
		
		System.out.println( name + address + phone );
		
		contacts.writeFile (name, address, phone );
	}
}
