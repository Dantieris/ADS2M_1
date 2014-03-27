package com.senac.bank.system;

import com.senac.bank.account.*;
import com.senac.bank.console.Console;
import com.senac.bank.members.Cliente;

public class System 
{
	private Cliente client;
	private Console console;
	
	public System()
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
	
	//return an investiment account.
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
	
}
