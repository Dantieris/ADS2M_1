package com.senac.estruturas;

// Implementação de lista Recursiva
public class ListaDuplaEncadeadaOrdenadaRecursiva<T extends Comparable<T>> {
	private NodoDuplaRecursiva<T> head;
	
	public void insere(NodoDuplaRecursiva<T> novo) {
		if ( head == null ) {
			head = novo;
		}
		else {
			head.insere(novo);
		}
	}
	
	public void remove(T valor) {
		NodoDuplaRecursiva<T> nodo = procure(valor);
		nodo.remove();
		if ( nodo == head )
			head = head.getNext();
	}
	
	public NodoDuplaRecursiva<T> procure(T valor) {
		if ( head == null )
			return head;
		else
			return head.procura(valor);
	}

}
