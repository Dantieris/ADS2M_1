package com.senac.bank.accounts.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.senac.PraticaOOP.Controler;
import com.senac.bank.accounts.files.FileBankRegisters;
import com.senac.bank.console.Console;
import com.senac.contacts.files.FileContacts;

public class BankRegistersController 
{
	FileBankRegisters bankRegister 	= null;
	Controler contactGenerator 		= null;
	Console printer 				= null;
	
	public BankRegistersController()
	{
		bankRegister		= new FileBankRegisters();
		contactGenerator 	= new Controler();
		printer 			= new Console();
	}
	
	//create contacts.txt file.
	public void createFile()
	{
		Path path = Paths.get(System.getProperty( "user.home" ), "bankRegisters.txt");
		bankRegister.createFile( path.toString() );
	}
	
	//close file.
	public void saveFile()
	{
		bankRegister.closeFile();
	}
	
	//record on file.
	public void recordContacts()
	{
		Scanner contacts = null;
		
		try 
		{
			contacts = new Scanner( new BufferedReader ( new FileReader ( "contacts.txt" ) ) );
		} 
		catch (FileNotFoundException e) 
		{
			printer.printError( "File not found." );
			return;
		}
		
		String contact = contacts.nextLine();
		
		bankRegister.saveContacts( contact, account );
		
		contacts.close();
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
