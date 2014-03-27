package com.senac.bank.console;

import java.util.Scanner;

public class Console 
{
	
	Scanner input = new Scanner( System.in );
	
	//return user name.
	public String inputName()
	{
		printLine( "Enter your name: " );
		return input.nextLine();
	}
	
	//return account balance.
	public double inputBalance()
	{
		printLine( "Enter the account intial balance: " );
		return input.nextDouble();
	}
	
	//return account withdrawal limit.
	public double inputLimit()
	{
		printLine( "Enter the account limit withdrawal: " );
		return input.nextDouble();
	}
	
	//return account number.
	public int inputAccountNumber()
	{
		printLine( "Enter the account number: " );
		return input.nextInt();
	}
	
	//print error, parameter message error.
	public void printErro( String message )
	{
		System.err.println( message );
	}
	
	//return account type.
	public String inputAccountType()
	{
		printLine( "Enter the account type: " );
		return input.next();
	}
	
	public int inputAccountConfirmationNumber()
	{
		printLine( "Enter the account confirmation number: " );
		return input.nextInt();
	}

	//parameter message to print.
	public void printLine( String message ) 
	{
		System.out.println( message );
	}

	//return the next user input line.
	public String inputLine() 
	{
		return input.nextLine();
	}
	
	//return the next user input word.
	public String inputWord()
	{
		return input.next();
	}

	//return the next user input double.
	public double inputDouble() 
	{
		return input.nextDouble();
	}

	//return the next user input int.
	public int inputInteger() 
	{
		return input.nextInt();
	}
	
}
