package com.senac.estruturas.vetor;

/**
 * Esta classe representa uma estrutura de dados Vetor. 
 * A implementa��o � feita a partir de um vetor est�tico.
 *
 */
public class Vetor<T> {
	protected Object[] dados;
	
	/**
	 * Inicializa um objeto Vetor<T> rec�m-criado com o tamanho definido pelo parametro.
	 * 
	 * @param tamanho O tamanho do vetor.
	 */
	public Vetor( int tamanho ){
		this.dados = new Object [tamanho];
	}
	
	/**
	 * Inicializa um objeto Vetor<T> rec�m-criado com um espa�o.
	 * 
	 */
	public Vetor() {
		this.dados = new Object [1];
	}
	
	/**
	 * Modifica um elemento do vetor.
	 * 
	 * @param indice Posi��o do elemento no vetor.
	 * @param valor Valor a ser modificado.
	 */
	public void put(int indice, T valor) {
		this.dados[indice] = valor;
	}
	
	/**
	 * Acessa um item do vetor.
	 * 
	 * @param indice Posi��o do item.
	 * @return O valor na posi��o do indice.
	 */
	@SuppressWarnings("unchecked")
	public T get(int indice) {
		return (T) this.dados[indice];
	}
	
	/**
	 * Acessa o tamanho do vetor.
	 * 
	 * @return Um inteiro contetndo o tamanho do vetor.
	 */
	public int getLength() {
		return dados.length;
	}
	
	/**
	 * Acessa o vetor de dados.
	 
	 * @return O vetor de dados.
	 */
	@SuppressWarnings("unchecked")
	public T[] getDados() {
		return (T[]) dados;
	}
	
	/**
	 * Modifica o tamanho do vetor.
	 * 
	 * @param newLength O novo tamanho.
	 */
	public void setLength( int newLength ) {
		if ( dados.length != newLength ) {
			Object [] newDados = new Object[newLength];
			
			int min = dados.length < newLength ?
					dados.length : newLength;
			
			for ( int i = 0 ; i < min ; i++ )
				newDados [i] = dados [i];
			dados = newDados;
		}
	}
	
}
