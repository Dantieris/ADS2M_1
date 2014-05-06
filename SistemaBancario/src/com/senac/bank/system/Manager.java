package com.senac.bank.system;

import com.senac.bank.account.*;
import com.senac.bank.console.BankConsole;
import com.senac.bank.exceptions.NoClientFoundException;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bank.members.Cliente;

public class Manager
{
	private Cliente client;
	private BankConsole console;
	
	public Manager()
	{
		console = new BankConsole();
	}
	
	//return the client.
	public Cliente getClient()
	{
		return this.client;
	}

	//register a client in the system.
	private void registeringClient()
	{
		client = new Cliente( console.inputName()  
				, registeringAccount() );
	}
	
	//register an account according to the type.
	private Conta registeringAccount()
	{
		Conta account = null;
		String type = console.inputAccountType();
		
		if ( type.equalsIgnoreCase( "common" ) )
		{
			account = new Conta();
		}
		else
			if ( type.equalsIgnoreCase( "especial" ) )
			{
				account = new Especial( console.inputLimit() );
			}
			else
				if ( type.equalsIgnoreCase( "investment" ) )
				{
					account = new Investimento();
				}
				else
						account = new Conta();
		
		return account;
	}
	
	//show a menu with operations.
	//1 to register client.
	//2 to deposit an amount to the account.
	//3 to withdraw an amount of the account.
	//4 to print the extract.
	//5 to close the application.
	public void menuOperations()
	{
			console.printMenuOperations();
			
			int operations = console.inputInteger();
			
			switch ( operations )
			{
			//operation register client.
			case 1 : 
				{
					if ( getClient() == null )
						registeringClient(); 
					else
					{
						console.printError("There is one client registered.");
					}
				}
					break;
			//operation deposit.
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
			//operation withdraw.
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
			//operation print extract.
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
			//operation close the application.
			case 5  : System.exit(0);
					break;
			
			default : console.printError( "Unknown Operation." );
					break;
			}
	}
	
}
