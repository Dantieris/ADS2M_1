package com.senac.bankregisters.apps;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.senac.bankregisters.controller.RegistersManager;

public class RegistersManagerApp {

	public static void main ( String args[] )
	{
		RegistersManager registersManager = null;
		
		try 
		{
			registersManager = new RegistersManager();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println( "I/O failed." );
		}
		
		if (registersManager != null) {
		if ( !registersManager.isRegistersEmpty() )
			registersManager.recordBankRegisterForEachContact();
		else {
			try 
			{	
				registersManager.updateBankRegisters();
			} 
			catch (FileNotFoundException e) {
				System.out.println( "File not found." );
			}
		}
		
		registersManager.saveFiles();
		}
	}
}
