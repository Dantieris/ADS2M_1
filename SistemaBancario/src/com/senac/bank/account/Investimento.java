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

	public int getDataCriacao() 
	{
		return this.data;
	}
	
	public double getTaxa()
	{
		return this.taxa;
	}
	
	public void dividendos( double taxa )
	{
		
	}
	
}
