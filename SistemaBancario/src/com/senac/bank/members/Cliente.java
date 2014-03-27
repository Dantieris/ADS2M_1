package com.senac.bank.members;

import com.senac.bank.account.Conta;

public class Cliente
{
	private Conta account;
	private String name;
	
	public Cliente( String name, Conta account ) 
	{
		this.account 	= account;	
		this.name		= name;
	}

	//return the client account.
	public Conta getAccount() 
	{
		return account;
	}

	//define the client account.
	public void setAccount( Conta account ) 
	{
		this.account = account;
	}
	
	//define the client name.
	public void setName( String name )
	{
		this.name = name;
	}
	
	//return the client name.
	public String getName()
	{
		return name;
	}
	
}
