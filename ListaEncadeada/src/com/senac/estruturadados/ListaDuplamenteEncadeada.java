package com.senac.estruturadados;

public class ListaDuplamenteEncadeada<T extends Comparable<T>> {
	private NodoDuplo<T> head;
	private NodoDuplo<T> tail;
	
	public NodoDuplo<T> getHead() {
		return head;
	}
	public void setHead(NodoDuplo<T> head) {
		this.head = head;
	}
	public NodoDuplo<T> getTail() {
		return tail;
	}
	public void setTail(NodoDuplo<T> tail) {
		this.tail = tail;
	}
	
	public void inserir(NodoDuplo<T> nodo) {
		if ( vazia() ) {
			setHead(nodo);
		}
		
		if ( nodo.getAnterior() == null ) {
			nodo.setNext(head);
			nodo.setAnterior(null);
			
			setHead(nodo);
		}
		else {
			
		}
			
	}
	
	private boolean vazia() {
		return head == null;
	}
	
}
