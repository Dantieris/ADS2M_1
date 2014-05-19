package com.senac.estruturadados;

public class NodoDuplo<T> {
	private T valor;
	private NodoDuplo<T> next;
	private NodoDuplo<T> anterior;
	
	public NodoDuplo(T valor) {
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public NodoDuplo<T> getNext() {
		return next;
	}
	public void setNext(NodoDuplo<T> next) {
		this.next = next;
	}
	public NodoDuplo<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDuplo<T> anterior) {
		this.anterior = anterior;
	}

}
