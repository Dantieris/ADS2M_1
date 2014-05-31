package com.senac.bank.members;

import com.senac.bank.account.Conta;

/**
 * 
 * Esta classe representa um cliente de um sistema bancário, possui nome, e conta.
 * 
 */
public class Cliente
{
	private Conta account;
	private String name;
	
	/**
	 * Inicializa um objeto Cliente recém-criado com nome e conta definidos por parametro.
	 * 
	 * @param name O nome do cliente.
	 * @param account A conta do cliente.
	 */
	public Cliente( String name, Conta account ) 
	{
		this.account 	= account;	
		this.name		= name;
	}

	/**
	 * Informa a conta do cliente.
	 * 
	 * @return A conta do cliente.
	 */
	public Conta getAccount() 
	{
		return account;
	}

	/**
	 * Define uma conta ao cliente.
	 * 
	 * @param account A conta a ser definida.
	 */
	public void setAccount( Conta account ) 
	{
		this.account = account;
	}
	
	/**
	 * Define o nome do cliente.
	 * 
	 * @param name O nome do cliente.
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * Informa o nome do cliente.
	 * 
	 * @return O nome do cliente.
	 */
	public String getName()
	{
		return name;
	}
	
}
