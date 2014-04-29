package com.senac.bankregisters.apps;

import com.senac.bankregisters.controller.RegistersManager;

public class RegistersManagerApp {

	public static void main ( String args[] )
	{
		RegistersManager registersManager = new RegistersManager();
		
		registersManager.startSystem();
	}
}
