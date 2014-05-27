package com.senac.estruturas;

// Implementação de lista Iterativa
public class NodoDuplaIterativa<T extends Comparable<T>> {
	private NodoDuplaIterativa<T> anterior;
	private NodoDuplaIterativa<T> proximo;
	private T valor;
	
	public NodoDuplaIterativa<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDuplaIterativa<T> anterior) {
		this.anterior = anterior;
	}
	public NodoDuplaIterativa<T> getProximo() {
		return proximo;
	}
	public void setProximo(NodoDuplaIterativa<T> proximo) {
		this.proximo = proximo;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	
}
