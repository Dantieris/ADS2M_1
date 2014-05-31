package com.senac.estruturadados;

public class ListaEncadeadaOrdenada<T extends Comparable<T>> {

	private Nodo<T> head;

	public void setHead(Nodo<T> head) {
		this.head = head;
	}
	
	public Nodo<T> getHead() {
		return head;
	}

	public void inserir( Nodo<T> nodo ) {
		head = nodo;
	}
	
}
