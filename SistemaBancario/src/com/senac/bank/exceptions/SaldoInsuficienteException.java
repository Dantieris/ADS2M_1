package com.senac.bank.exceptions;

/**
 * Esta classe representa uma exceção de saldo insuficiente, 
 * utilizada para operações de contas bancárias.
 *
 */
public class SaldoInsuficienteException extends Exception 
{
	private static final long serialVersionUID = 8766644292558311761L;
	
	/**
	 * Inicializa um objeto SaldoInsuficienteException recém-criado com a seguinte mensagem: "Insufficiente funds.".
	 */
	public SaldoInsuficienteException()
	{
		super( "Insufficient funds." );
	}
	
}
