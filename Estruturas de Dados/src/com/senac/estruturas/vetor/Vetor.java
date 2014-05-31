package com.senac.estruturas.vetor;

/**
 * Esta classe representa uma estrutura de dados Vetor. 
 * A implementação é feita a partir de um vetor estático.
 *
 */
public class Vetor<T> {
	protected Object vetor[];
	
	/**
	 * Inicializa um objeto Vetor<T> recém-criado com o tamanho definido pelo parametro.
	 * 
	 * @param tamanho O tamanho do vetor.
	 */
	public Vetor( int tamanho ){
		this.vetor = new Object [tamanho];
	}
	
	/**
	 * Inicializa um objeto Vetor<T> recém-criado com um espaço.
	 * 
	 */
	public Vetor() {
		this.vetor = new Object [1];
	}
	
}
