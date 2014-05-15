package com.senac.estruturadados;

public class ListaEncadeadaOrdenada<T extends Comparable<T>> {

	@SuppressWarnings("rawtypes")
	private Nodo head;

	@SuppressWarnings("rawtypes")
	public void setHead(Nodo head) {
		this.head = head;
	}
	
	@SuppressWarnings("rawtypes")
	public Nodo getHead() {
		return head;
	}

	public void inserir(@SuppressWarnings("rawtypes") Nodo nodo) {
		head.setNext(nodo);
	}
	
}
