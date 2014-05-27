package com.senac.estruturas;

// Implementação de lista Recursiva
public class NodoDuplaRecursiva<T extends Comparable<T>> {
	private T valor;
	private NodoDuplaRecursiva<T> proximo;
	private NodoDuplaRecursiva<T> anterior;
	
	public NodoDuplaRecursiva(T valor) {
		this.valor = valor;
		this.proximo = null;
	}
	
	public NodoDuplaRecursiva<T> procura( T valor ) {
		if ( valor == this.valor )
			return this;
		else
			if ( proximo.equals(null) ) 
				return null;
			else
				return proximo.procura(valor);
	}
	
	public void insere(NodoDuplaRecursiva<T> novo) {
		if ( novo.valor.compareTo(this.valor) > 0) 
			proximo.insere(novo);
		else {
			novo.anterior = this.anterior;
			novo.proximo = this;
			this.anterior.proximo = novo;
			this.anterior = novo;
		}
	}

	public NodoDuplaRecursiva<T> getNext() {
		return proximo;
	}

	public void remove() {
		if ( anterior != null )
			anterior.proximo = proximo;
		if ( proximo != null )
			proximo.anterior = this.anterior;
	}
}
