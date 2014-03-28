package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

public class Conta 
{
	private double saldo;
	private int numConta;
	private int numVerificacao;
	
	public Conta( int accountNumber, int accountVerificationNumber, double balance )
	{
		this.numConta 		= accountNumber;
		this.numVerificacao = accountVerificationNumber;
		this.saldo 			= balance;
	}
	
	//return the account balance.
	public double getBalance() 
	{
		return saldo;
	}

	//define the account balance.
	protected void setBalance( double balance ) 
	{
		this.saldo = balance;
	}

	//return the account number.
	public int getAccountNumber() 
	{
		return numConta;
	}

	//return the account confirmation number.
	public int getVerificationNumber() 
	{
		return numVerificacao;
	}

	//define the account confirmation number.
	public void setVerificationNumber( int verificationNumber ) 
	{
		this.numVerificacao = verificationNumber;
	}
	
	//add an value to the current balance.
	public void depositar( double value )
	{
		setBalance( getBalance() + value );
	}
	
	//reduce an value from the current balance.
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( getBalance() < value )
			throw new SaldoInsuficienteException();
		
		setBalance( getBalance() - value );
	}
	
}
