package com.senac.banco.exceptions;

public class SaldoInsuficienteException extends Exception 
{
	private String mensagem;
	
	public SaldoInsuficienteException( String mensagem )
	{
		super( mensagem );
		
		this.mensagem = mensagem;
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
	
}
