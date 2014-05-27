package com.senac.estruturadados;

public class Nodo<T> {

	private T valor;
	private Nodo<T> next;
	
	public void setValor( T valor ) {
		this.valor = valor;
		this.next  = null;
	}

	public T getValor() {
		return valor;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public Nodo<T> getNext() {
		return next;
	}

}
