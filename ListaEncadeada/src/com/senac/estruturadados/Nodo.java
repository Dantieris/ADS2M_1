package com.senac.estruturadados;

public class Nodo<T> {

	private T valor;
	private Nodo next;
	
	public void setValor( T valor ) {
		this.valor = valor;
		this.next  = null;
	}

	public T getValor() {
		return valor;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Nodo getNext() {
		return next;
	}

}
