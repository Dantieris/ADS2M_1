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
	
	public void purge() {
		while ( count > 0 )
			vetor[--count] = null;
	}

	public void accept(Visitor visitor) {
		for ( int i = 0 ; i < count ; i++ ) {
			visitor.visit(vetor [i]);
			if ( visitor.isDone() )
				return;
		}
		
	}

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

	public Object getTop() throws ContainerEmptyException {
		if ( isEmpty() )
			throw new ContainerEmptyException();
		return vetor [count - 1];
	}

	public void push(Object obj) throws ContainerFullException {
		if ( count == vetor.length )
			throw new ContainerFullException ();
		vetor[count++] = obj;
	}

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

}
