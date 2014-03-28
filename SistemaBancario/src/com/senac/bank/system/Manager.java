package com.senac.bank.system;

import com.senac.bank.account.*;
import com.senac.bank.console.Console;
import com.senac.bank.exceptions.NoClientFoundException;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bank.members.Cliente;

public class Manager
{
	private Cliente client;
	private Console console;
	
	public Manager()
	{
		console = new Console();
	}
	
	//return the client.
	public Cliente getClient()
	{
		return this.client;
	}

	//register a client in the system.
	public void registeringClient()
	{
		client = new Cliente( console.inputName()  
				, registeringAccount() );
	}
	
	//register an account according to the type.
	public Conta registeringAccount()
	{
		Conta account = null;
		String type = console.inputAccountType();
		
		if ( type.equalsIgnoreCase( "common" ) )
		{
			account = registeringCommonAccount();
		}
		
		if ( type.equalsIgnoreCase( "especial" ) )
		{
			account = registeringEspecialAccount();
		}
		
		if ( type.equalsIgnoreCase( "investiment" ) )
		{
			account = registeringInvestimentAccount();
		}
		
		return account;
	}
	
	//return a common account.
	private Conta registeringCommonAccount()
	{
		return new Conta ( console.inputAccountNumber()
				, console.inputAccountConfirmationNumber()
				, console.inputBalance() );
	}
	
	//return an investment account.
	private Investimento registeringInvestimentAccount()
	{
		return new Investimento ( console.inputAccountNumber() 
				, console.inputAccountConfirmationNumber()
				, console.inputBalance() 
				, 0
				, 0.43 );
	}
	
	//return an especial account.
	private Especial registeringEspecialAccount()
	{
		return new Especial ( console.inputAccountNumber()
				, console.inputAccountConfirmationNumber() 
				, console.inputBalance()
				, console.inputLimit() );
	}

	//show a menu with operations.
	//1 to register client.
	//2 to deposit an amount to the account.
	//3 to withdraw an amount of the account.
	//4 to print the extract.
	//5 to close the app.
	public void menuOperations()
	{
			console.printMenuOperations();
			
			int operations = console.inputInteger();
			
			switch ( operations )
			{
			case 1 : 
				{
					if ( getClient() == null )
						registeringClient(); 
					else
					{
						console.printError("There is one client registered already.");
					}
				}
					break;
			case 2 : 
				{
					try
					{
						if ( getClient() == null )		
							throw new NoClientFoundException();
						
						client.getAccount().depositar( console.inputAmountToDeposit() );
						
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}					
				}
					break;
			case 3 : 
				{
					try
					{
						if ( getClient() == null )
							throw new NoClientFoundException();
						else
						{
							try
							{
								client.getAccount().sacar( console.inputAmountToWithdrawal() );
							}
							catch ( SaldoInsuficienteException e )
							{
								console.printError( e.getMessage() + ". Available balance " + client.getAccount().getBalance() );
							}	
						}
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}
					
				}
					break;
			case 4  : 
				{
					try
					{
						if ( getClient() == null)
							throw new NoClientFoundException();
						else
						{
							console.printExtract( client.getAccount().getAccountNumber()
									, client.getAccount().getVerificationNumber()
									, client.getAccount().getBalance() );
						}
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}
				}
					break;
					
			case 5  : System.exit(0);
					break;
			
			default : console.printError( "Unknown Operation." );
					break;
			}
	}
	
}
