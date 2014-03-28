package com.senac.bank.console;

import java.util.Scanner;

public class Console 
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

	//parameter message to print.
	public void printLine( String message ) 
	{
		System.out.println( message );
	}

	//return the next user input line.
	public String inputLine() 
	{
		return extracted().nextLine();
	}
	
	//return the next user input word.
	public String inputWord()
	{
		return extracted().next();
	}

	//return the next user input double.
	public double inputDouble() 
	{
		return extracted().nextDouble();
	}

	//return the next user input integer.
	public int inputInteger() 
	{
		return extracted().nextInt();
	}
	
	public void printMenuOperations()
	{
		printLine( "\n=== Operations ==="
				+ "\n1 - Register Client"
				+ "\n2 - Deposit"
				+ "\n3 - Withdrawal"
				+ "\n4 - Exit" );
	}
	
}
