package com.senac.banco.members;

import com.senac.banco.account.Conta;

public class Cliente
{
	private Conta conta;
	private String nome;
	
	public Cliente( String nome, Conta conta ) 
	{
		this.conta = conta;		
	}

	public Conta getConta() 
	{
		return conta;
	}

	public void setConta( Conta conta ) 
	{
		this.conta = conta;
	}
	
	public void setNome( String nome )
	{
		this.nome = nome;
	}
	
	public String getNome()
	{
		return nome;
	}
	
}
