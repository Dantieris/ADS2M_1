package com.senac.filesystem.manager;

import java.io.FileNotFoundException;
import java.util.Formatter;

import com.senac.bank.console.Console;

public class FileManager 
{
	private Formatter file;
	private Console console;
	
	public FileManager()
	{
		file = null;
	}
	
	//
	public void openFile()
	{
		if ( !isFileExisting() )
		{
			
		}
	}
	
	//create a new file named contacts.txt.
	public void createFile()
	{
		try
		{
			file = new Formatter( "contacts.txt" );
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
	
	//
	public void editFile()
	{
		
	}
	
	//
	public void readeFile()
	{
		
	}
	
	//close a existing file.
	public void closeFile()
	{
		if ( !isFileExisting() )
			file.close();
	}
	
	//returns true if file is different from null,
	//else returns false.
	private boolean isFileExisting()
	{
		if ( file.equals( null ) )
			return false;
		else
			return true;
	}
	
}
