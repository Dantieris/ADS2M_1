package com.senac.estruturas;

import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

public class Pilha {

	protected Object vetor[];
	protected int count;
	
	/**
	 * Inicializa um objeto Pilha recém-criado, com o tamanho definido por parâmetro.
	 * 
	 * @param tamanho O espaço total da pilha.
	 */
	public Pilha(int tamanho) {
		vetor = new Object [tamanho];
		count = 0;
	}

	/**
	 * Retorna o ultimo elemento da pilha.
	 * 
	 * @return O último item da pilha.
	 */
	public Object getTop() throws ContainerEmptyException {
		if ( isEmpty() )
			throw new ContainerEmptyException();
		return vetor [count - 1];
	}

	/**
	 * Adiciona um elemento na pilha.
	 * 
	 * @param Object obj - O elemento a ser inserido na pilha.
	 */
	public void push(Object obj) throws ContainerFullException {
		if ( count == vetor.length )
			throw new ContainerFullException ();
		vetor[count++] = obj;
	}

	/**
	 * Retira um elemento da pilha.
	 * 
	 * @return O elemento que foi retirado.
	 */
	public Object pop() throws ContainerEmptyException {
		if ( isEmpty() )
			throw new ContainerEmptyException ();
		Object resultado = vetor [--count];
		vetor [count] = null;
		return resultado;
	}

	/**
	 * Informa se a pilha está cheia.
	 * 
	 * @return Verdadeiro se estiver cheia, falso senão.
	 */
	public boolean isFull() {
		return count == vetor.length -1;
	}
	
	/**
	 * Informa se a pilha está vazia.
	 * 
	 * @return Verdadeiro se estiver vazia, falso senão.
	 */
	public boolean isEmpty() {
		return count == 0;
	}
}
