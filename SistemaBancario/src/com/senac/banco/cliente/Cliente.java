package com.senac.banco.cliente;

import com.senac.banco.conta.Conta;
import com.senac.util.Pessoa;

public class Cliente extends Pessoa
{
	private Conta conta;
	
	public Cliente( String nome, String endereco, String[] telefone, Conta conta ) 
	{
		super( nome, endereco, telefone );
		
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
	
}
