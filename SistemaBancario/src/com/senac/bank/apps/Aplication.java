package com.senac.bank.apps;

import com.senac.bank.system.Manager;

public class Aplication 
{

	public static void main(String[] args) 
	{
		Manager bankManager = new Manager();
		do
		{
			bankManager.menuOperations();
		}
		while (true);
	}

}
