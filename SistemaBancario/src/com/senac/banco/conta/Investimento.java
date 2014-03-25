package com.senac.banco.conta;

public class Investimento extends Conta
{
	private int dataCriacao;
	private final double taxa;
	
	public Investimento( int numConta, int numVerificacao, double saldo, int dataCriacao, double taxa) 
	{
		super( numConta, numVerificacao, saldo );
		
		this.dataCriacao 	= dataCriacao;
		this.taxa 		 	= taxa;
	}

	public int getDataCriacao() 
	{
		return this.dataCriacao;
	}

	public void setDataCriacao( int dataCriacao ) 
	{
		this.dataCriacao = dataCriacao;
	}
	
	public double getTaxa()
	{
		return this.taxa;
	}
	
	public void dividendos( double taxa )
	{
		
	}
	
}
