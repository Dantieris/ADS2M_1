package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

public class Especial extends Conta 
{
	private double limite;
	
	public Especial( int accountNumber, int accountConfirmationNumber, double balance, double limitWithdrawal ) 
	{
		super( accountNumber, accountConfirmationNumber, balance );
		
		this.limite = limitWithdrawal;
	}

	//return the withdrawal limit.
	public double getLimite() 
	{
		return limite;
	}

	//define the withdrawal limit.
	public void setLimite( double limite ) 
	{
		this.limite = limite;
	}
	
	//reduce an value from the current balance.
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( value > getLimite() )
			throw new SaldoInsuficienteException();
		
		setBalance( getBalance() - value );
	}
	
}
