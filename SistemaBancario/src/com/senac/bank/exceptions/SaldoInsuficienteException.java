package com.senac.bank.exceptions;

/**
 * Esta classe representa uma exce��o de saldo insuficiente, 
 * utilizada para opera��es de contas banc�rias.
 *
 */
public class SaldoInsuficienteException extends Exception 
{
	private static final long serialVersionUID = 8766644292558311761L;
	
	/**
	 * Inicializa um objeto SaldoInsuficienteException rec�m-criado com a seguinte mensagem: "Insufficiente funds.".
	 */
	public SaldoInsuficienteException()
	{
		super( "Insufficient funds." );
	}
	
}
