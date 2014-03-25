package com.senac.banco.conta;

public class Investimento extends Conta
{
	private int dataCriacao;
	
	public Investimento( int numConta, int numVerificacao, double saldo, int dataCriacao ) 
	{
		super( numConta, numVerificacao, saldo );
		
		this.dataCriacao = dataCriacao;
	}

	public int getDataCriacao() 
	{
		return dataCriacao;
	}

	public void setDataCriacao( int dataCriacao ) 
	{
		this.dataCriacao = dataCriacao;
	}
	
	public void dividendos( double taxa )
	{
		
	}
	
	

}
