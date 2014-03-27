package com.senac.bank.account;

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
	
}
