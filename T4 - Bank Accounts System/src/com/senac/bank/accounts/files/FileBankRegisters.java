package com.senac.bank.accounts.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import com.senac.bank.console.Console;

public class FileBankRegisters 
{
	Formatter bankAccounts = null;
	Console printer = null;
	
	public FileBankRegisters()
	{
		printer  = new Console();
		bankAccounts = new Formatter();
	}
	
	//create a file.
	public void createFile( String path )
	{
		try
		{
			bankAccounts = new Formatter( new BufferedWriter ( new FileWriter( path ) ) );
		}
		catch ( SecurityException se )
		{
			printer.printError( "You dont have write access to this file." );
			return;
		}
		
		catch ( FileNotFoundException fnfe )
		{
			printer.printError(  
					"Error creating file." );
			return;
		}
		
		catch ( IOException ioe )
		{
			printer.printError( 
					"Error creation file failed." );
			return;
		}
	}
	
	//save a bank register on file.
	public void saveContacts( String contact, String account )
	{
		try
		{
			bankAccounts.format( "Account: " , 
					account ,
					contact
					);
		}
		catch ( FormatterClosedException fce )
		{
			printer.printError( "Error writing to file." );
			return;
		}
	}
	
	//close an existing file.
	public void closeFile()
	{
		bankAccounts.close();
	}
}
