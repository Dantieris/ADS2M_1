package com.senac.banco.conta;

public class Conta 
{
	private double saldo;
	private int numConta;
	private int numVerificacao;
	
	public Conta( int numConta, int numVerificacao, double saldo )
	{
		this.numConta 		= numConta;
		this.numVerificacao = numVerificacao;
		this.saldo 			= saldo;
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public void setSaldo( double saldo ) 
	{
		this.saldo = saldo;
	}

	public int getNumConta() 
	{
		return numConta;
	}

	public void setNumConta( int numConta ) 
	{
		this.numConta = numConta;
	}

	public int getNumVerificacao() 
	{
		return numVerificacao;
	}

	public void setNumVerificacao( int numVerificacao ) 
	{
		this.numVerificacao = numVerificacao;
	}
	
	public void depositar( double valor )
	{
		
	}
	
	public void sacar( double valor )
	{
		
	}
	
}
