package com.senac.bank.account;

public class Investimento extends Conta
{
	private int data;
	private final double taxa;
	
	public Investimento( int numConta, int numVerificacao, double saldo, int data, double taxa) 
	{
		super( numConta, numVerificacao, saldo );
		
		this.data 	= data;
		this.taxa 	= taxa;
	}

	//return the date creation.
	public int getDataCriacao() 
	{
		return this.data;
	}
	
	//return the investment rate.
	public double getTaxa()
	{
		return this.taxa;
	}
	
	//calculates a percentage of profit based on the current balance.
	public void dividendos( double taxa )
	{
		setBalance( ( (getBalance() / 100 ) * taxa) + getBalance() );
	}
	
}
