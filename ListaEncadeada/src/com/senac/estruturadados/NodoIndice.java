package com.senac.estruturadados;

public class NodoIndice<T> {
	private NodoIndice<T> proximo;
	private NodoIndice<T> anterior;
	private NodoDuplo<T> alvo;
	private T valor;
	
	public NodoIndice(T valor){
		this.valor = valor;
	}
	
	public NodoIndice<T> getProximo() {
		return proximo;
	}
	public void setProximo(NodoIndice<T> proximo) {
		this.proximo = proximo;
	}
	public NodoIndice<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoIndice<T> anterior) {
		this.anterior = anterior;
	}
	public NodoDuplo<T> getAlvo() {
		return alvo;
	}
	public void setAlvo(NodoDuplo<T> alvo) {
		this.alvo = alvo;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	
}
