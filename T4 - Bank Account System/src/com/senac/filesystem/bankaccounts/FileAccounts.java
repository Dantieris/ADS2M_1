package com.senac.filesystem.bankaccounts;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import com.senac.bank.console.Console;

public class FileAccounts 
{
	private Formatter file;
	private Console console;
	
	public FileAccounts()
	{
		file = null;
	}
	
	//create one file named accounts.txt.
	public void createFile()
	{
		try
		{
			file = new Formatter( "accounts.txt" );
		}
		catch ( SecurityException se )
		{
			console.printError( 
					"You dont have write access to this file." );
		return;
		}
		catch ( FileNotFoundException fnfe )
		{
			console.printError(  
					"Error creating file." );
			return;
		}
	}
	
	//record in file: name, address and phone.
	public void writeFile( String name, String address, String phone )
	{
		try
		{
			file.format( "Name: %s - Address: %s - Phone: %s%n" , 
					name,
					address,
					phone
					);
		}
		catch ( FormatterClosedException fce )
		{
			console.printError( "Error writing to file." );
			return;
		}
		
	}
	
	//close the file.
	public void closeFile()
	{
		file.close();
	}

}