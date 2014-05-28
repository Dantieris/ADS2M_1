package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

public class Especial extends Conta 
{
	private double limite;
	
	public Especial( double limite ) 
	{
		super();
		this.limite = limite;
		
		if (limite < 0)
			this.limite = 1000.0;
	}

	//return the withdrawal limit.
	public double getLimite() 
	{
		return limite;
	}
	
	//reduce an value from the current balance.
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( value > getLimite() || value < 0 )
			throw new SaldoInsuficienteException();
		
		saldo -= value;
	}
	
	public String getType() {
		return "Especial";
	}
}
