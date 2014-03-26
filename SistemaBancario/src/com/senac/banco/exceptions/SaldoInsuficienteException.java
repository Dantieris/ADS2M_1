package com.senac.banco.exceptions;

public class SaldoInsuficienteException extends Exception 
{
	private static final long serialVersionUID = 8766644292558311761L;
	
	public SaldoInsuficienteException()
	{
		super( "Saldo Insuficiente" );
	}
	
}
