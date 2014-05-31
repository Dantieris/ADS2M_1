package com.senac.estruturas.vetor;

/**
 * Esta classe representa uma estrutura de dados Vetor. 
 * A implementa��o � feita a partir de um vetor est�tico.
 *
 */
public class Vetor<T> {
	protected Object vetor[];
	
	/**
	 * Inicializa um objeto Vetor<T> rec�m-criado com o tamanho definido pelo parametro.
	 * 
	 * @param tamanho O tamanho do vetor.
	 */
	public Vetor( int tamanho ){
		this.vetor = new Object [tamanho];
	}
	
	/**
	 * Inicializa um objeto Vetor<T> rec�m-criado com um espa�o.
	 * 
	 */
	public Vetor() {
		this.vetor = new Object [1];
	}
	
}
