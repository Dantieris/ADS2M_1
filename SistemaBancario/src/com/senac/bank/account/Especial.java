package com.senac.bank.account;

public class Especial extends Conta 
{
	private double limite;
	
	public Especial( int numConta, int numVerificacao, double saldo, double limite) 
	{
		super( numConta, numVerificacao, saldo );
		
		this.limite = limite;
	}

	public double getLimite() 
	{
		return limite;
	}

	public void setLimite( double limite ) 
	{
		this.limite = limite;
	}
	
}
