package com.senac.bankregisters.view;

import com.senac.bank.console.BankConsole;

/**
 * Esta classe representa a view do sistema banc�rio, ir� imprimir e receber input do usu�rio.
 *
 */
public class BankView extends BankConsole{

	/**
	 * Imprime a op��o do menu gerar dividendos.
	 */
	public void printDividendsOperation()
	{
		System.out.println( "3 - Dividends Operation" );
	}
	
	/**
	 * Imprime um menu com op��o deposito e saque.
	 */
	public void printMenu()
	{
		System.out.println( "### Menu Operations ###"
				+ "\n1 - Deposit Operation"
				+ "\n2 - Withdrawal Operation" );
	}
}
