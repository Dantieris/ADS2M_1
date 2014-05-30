package com.senac.exceptions;

/**
 * Esta classe representa uma excecao de quando uma expressao matematica é invalida.
 * 
 * @author Dantieris Castilhos Rabelini
 */
public class ExpressaoInvalidaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8454137023499589022L;

	/**
	 * Inicializa um objeto ExpressaoInvalidaException recem-criado, definindo sua mensagem pelo parametro ms.
	 * 
	 * @param ms A mensagem que representa a excecao.
	 */
	public ExpressaoInvalidaException( String ms ) {
		super( ms );
	}
	
	/**
	 * Inicializa um objeto ExpressaoInvalidaException recem-criado. 
	 */
	public ExpressaoInvalidaException() {
		super();
	}
}
