package com.senac.estruturadados;

public class Nodo<T> {

	private T valor;
	
	public void setValor( T valor ) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}

}
