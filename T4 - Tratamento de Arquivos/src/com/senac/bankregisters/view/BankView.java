package com.senac.bankregisters.view;

import com.senac.bank.console.BankConsole;

public class BankView extends BankConsole{


	public void printDepositOperation()
	{
		System.out.println( "1 - Deposit Operation" );
	}
	
	public void printWithdrawalOperation()
	{
		System.out.println( "2 - Withdrawal Operation" );
	}
	
	public void printDividendsOperation()
	{
		System.out.println( "3 - Dividends Operation" );
	}
	
	public void printMenu()
	{
		System.out.println( "### Menu Operations ###" );
	}
}
