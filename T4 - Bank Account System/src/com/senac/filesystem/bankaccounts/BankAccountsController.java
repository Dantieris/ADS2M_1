package com.senac.filesystem.bankaccounts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.senac.bank.console.Console;

public class BankAccountsController
{
	private Scanner input = null;
	private Console console;
	
	public BankAccountsController()
	{
		try
		{
			input = new Scanner ( new BufferedReader( new FileReader( "contacts.txt" ) ) );
		}
		catch ( Exception fnfe )
		{
			
		}
	}
	
	public void readContacts()
	{
		try
		{
			while ( input.hasNext() )
			{
				String message = input.nextLine();
				String message2 = input.next();
				console.printLine( message + message2 );
			}
		}
		catch ( NoSuchElementException nsee )
		{
			console.printError( "File improperly formed." );
			input.close();
			return;
		}
		catch ( IllegalStateException ise )
		{
			console.printError( "Error reading from file." );
			input.close();
			return;
		}
		finally
		{
			if ( input != null )
				input.close();
		}
	}
}
