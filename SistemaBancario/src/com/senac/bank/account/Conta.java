package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

public class Conta 
{
	private double saldo;
	private int numConta;
	private int numVerificacao;
	
	public Conta( int numConta, int numVerificacao, double saldo )
	{
		this.numConta 		= numConta;
		this.numVerificacao = numVerificacao;
		this.saldo 			= saldo;
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public void setSaldo( double saldo ) 
	{
		this.saldo = saldo;
	}

	public int getNumConta() 
	{
		return numConta;
	}

	public void setNumConta( int numConta ) 
	{
		this.numConta = numConta;
	}

	public int getNumVerificacao() 
	{
		return numVerificacao;
	}

	public void setNumVerificacao( int numVerificacao ) 
	{
		this.numVerificacao = numVerificacao;
	}
	
	public void depositar( double valor )
	{
		
	}
	
	//reduz um valor do salto total.
	//parametro double valor, informa o valor a ser retirado da conta.
	public void sacar( double valor ) throws SaldoInsuficienteException
	{
		
		if ( saldo < valor )
			throw new SaldoInsuficienteException();
		else
		{
			setSaldo( getSaldo() - valor );
		}
	}
	
}
