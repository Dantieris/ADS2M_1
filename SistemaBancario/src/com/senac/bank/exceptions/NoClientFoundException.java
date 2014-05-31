package com.senac.bank.exceptions;

/**
 * Esta classe representa uma exce��o de nenhum cliente encontrado, 
 * utilizada para opera��es com clientes.
 *
 */
public class NoClientFoundException extends Exception {
	
	private static final long serialVersionUID = 3523522482751843335L;
	
	/**
	 * Inicializa um objeto NoClientFoundException rec�m-criado com a seguinte mensagem: "No Clients Founds.".
	 */
	public NoClientFoundException()
	{
		super( "No Client Founds." );
	}

}
