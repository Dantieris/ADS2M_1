package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

public class Conta 
{
	
	private final String type = "Conta";
	protected double saldo;
	private int numConta;
	private int numVerificacao;
	private static int proximaConta = 10000;
	
	public Conta( )
	{
		this.numConta 		= proximaConta;
		proximaConta++;
		this.numVerificacao = this.numConta % 100;
		this.saldo 			= 0;
	}
	
	// Retorna o valor do saldo.
	public double getBalance() 
	{
		return saldo;
	}

	//
	protected void setBalance( double balance ) 
	{
		this.saldo = balance;
	}

	// Retorna o numero da conta.
	public int getAccountNumber() 
	{
		return numConta;
	}

	// Retorna o numero de verificacao.
	public int getVerificationNumber() 
	{
		return numVerificacao;
	}
	
	// Adiciona um valor ao saldo.
	public void depositar( double value )
	{
		if ( value > 0 )
			saldo += value;
	}
	
	// Retira um valor do saldo.
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( getBalance() < value || value < 0 )
			throw new SaldoInsuficienteException();
		
		saldo -= value;
	}
	
	public String getType() {
		return type;
	}
}
