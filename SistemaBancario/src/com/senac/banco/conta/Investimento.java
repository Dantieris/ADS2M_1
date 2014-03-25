package com.senac.banco.conta;

public class Investimento extends Conta
{
	private String dataCriacao;
	private final double taxa;
	
	public Investimento( int numConta, int numVerificacao, double saldo, String dataCriacao, double taxa) 
	{
		super( numConta, numVerificacao, saldo );
		
		this.dataCriacao 	= dataCriacao;
		this.taxa 		 	= taxa;
	}

	public String getDataCriacao() 
	{
		return this.dataCriacao;
	}

	public void setDataCriacao( String dataCriacao ) 
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
