package com.senac.estruturas;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.senac.estruturas.abstratos.AbstractContainer;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;
import com.senac.estruturas.interfaces.Visitor;

public class Pilha extends AbstractContainer implements com.senac.estruturas.interfaces.Pilha {

	protected Object vetor[];
	
	public Pilha(int tamanho) {
		vetor = new Object [tamanho];
	}
	
	/**
	 * Esvazia a pilha.
	 */
	public void purge() {
		while ( count > 0 )
			vetor[--count] = null;
	}

	/**
	 * Aceita um visitante e faz ele visitar um por um dos objetos da pilha.
	 * 
	 * @param Visitor visitor - O visitante que irá visitar os objetos da pilha.
	 */
	public void accept(Visitor visitor) {
		for ( int i = 0 ; i < count ; i++ ) {
			visitor.visit(vetor [i]);
			if ( visitor.isDone() )
				return;
		}
		
	}
	
	/**
	 * Retorna uma Enumeration da Pilha.
	 * 
	 * @return A Enumeration da pilha.
	 */
	@SuppressWarnings("rawtypes")
	public Enumeration getEnumeration() {
		return new Enumeration() {
			protected int posicao = 0;
			
			public boolean hasMoreElements() {
				return posicao < getCount();
			}
			
			public Object nextElement() {
				if (posicao >= getCount())
					throw new NoSuchElementException();
				return vetor [posicao++];
			}
		};
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
		Object resultado = vetor [-count];
		vetor [count] = null;
		return resultado;
	}

	protected int compareTo(com.senac.estruturas.interfaces.Comparable arg) {
		return 0;
	}
	
	/**
	 * Informa se a pilha está cheia.
	 * 
	 * @return Verdadeiro se estiver cheia, falso senão.
	 */
	public boolean isFull() {
		return count >= vetor.length;
	}
	
}
