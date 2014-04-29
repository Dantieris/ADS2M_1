package com.senac.bankregisters.view;

import com.senac.bank.console.BankConsole;

public class BankView extends BankConsole{

	public void printDividendsOperation()
	{
		System.out.println( "3 - Dividends Operation" );
	}
	
	public void printMenu()
	{
		System.out.println( "### Menu Operations ###"
				+ "\n1 - Deposit Operation"
				+ "\n2 - Withdrawal Operation" );
	}
}
