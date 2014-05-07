package com.senac.bank.console;

import java.util.Scanner;

public class BankConsole 
{
	
	//return a object type Scanner.
	private Scanner extracted() {
		return new Scanner( System.in );
	}
	
	//return user name.
	public String inputName()
	{
		printLine( "Enter your name: " );
		return extracted().nextLine();
	}
	
	//return account balance.
	public double inputBalance()
	{
		printLine( "Enter the account intial balance: " );
		return extracted().nextDouble();
	}
	
	//return account withdrawal limit.
	public double inputLimit()
	{
		printLine( "Enter the account limit withdrawal: " );
		return extracted().nextDouble();
	}
	
	//return account number.
	public int inputAccountNumber()
	{
		printLine( "Enter the account number: " );
		return extracted().nextInt();
	}
	
	//print error, parameter message error.
	public void printError( String message )
	{
		System.err.println( message );
	}
	
	//return account type.
	public String inputAccountType()
	{
		printLine( "Enter the account type: " );
		return extracted().next();
	}
	
	//return the account confirmation number.
	public int inputAccountConfirmationNumber()
	{
		printLine( "Enter the account confirmation number: " );
		return extracted().nextInt();
	}
	
	//return the amount of withdrawal.
	public double inputAmountToWithdrawal()
	{
		printLine( "Enter the amount to withdraw: " );
		return extracted().nextDouble();
	}
	
	//return the amount to deposit.
	public double inputAmountToDeposit()
	{
		printLine( "Enther the amount to deposit: " );
		return extracted().nextDouble();
	}
	
	//parameter message to print.
	public void printLine( String message ) 
	{
		System.out.println( message );
	}
	
	//return an integer.
	public int inputInteger()
	{
		return extracted().nextInt();
	}
	
	//print the extract of the account.
	public void printExtract( int accountNumber, int accountVerificationNumber, double accountBalance )
	{
		printLine( "\n=== Extract ==="
				+ "\nAccount Number: " + accountNumber + "-" + accountVerificationNumber
				+ "\nAccount Balance: " + accountBalance);
	}
	
	//print the menu operations of the system.
	public void printMenuOperations()
	{
		printLine( "\n=== Operations ==="
				+ "\n1 - Register Client"
				+ "\n2 - Deposit"
				+ "\n3 - Withdrawal"
				+ "\n4 - extract"
				+ "\n5 - Exit" );
	}
	
	// Imprimer os tipos de contas disponiveis para cadastro.
	public void printMenuAccountTypes()
	{
		printLine( "\n=== Acocunt Types ==="
				+ "\n1 - Common"
				+ "\n2 - Investment"
				+ "\n3 - Especial" );
	}
	
}
