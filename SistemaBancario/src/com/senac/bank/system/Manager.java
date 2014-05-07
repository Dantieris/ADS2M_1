package com.senac.bank.system;

import com.senac.bank.account.*;
import com.senac.bank.console.BankConsole;
import com.senac.bank.exceptions.NoClientFoundException;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bank.members.Cliente;

public class Manager
{
	private Cliente client;
	private Conta account;
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
	public void registeringClient()
	{
		client = new Cliente( console.inputName()  
				, account );
	}
	
	//register an account according to the type.
	public void registeringAccount()
	{
		int op = console.inputInteger();
		
		switch ( op )
		{
		case 1 : account = registeringCommonAccount(); break;
		case 2 : account = registeringInvestmentAccount(); break;
		case 3 : account = registeringEspecialAccount(); break;
		default: account = registeringCommonAccount();
		}

	}
	
	public Conta registeringCommonAccount() {
		return new Conta();
	}
	
	public Conta registeringInvestmentAccount() {
		return new Investimento();
	}
	
	public Conta registeringEspecialAccount() {
		return new Especial( 1000.0 );
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
