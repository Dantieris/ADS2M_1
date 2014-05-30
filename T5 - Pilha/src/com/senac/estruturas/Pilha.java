package com.senac.estruturas;

import com.senac.estruturas.exceptions.ContainerEmptyException;

/**
 * Armazena itens em uma pilha, o tipo da pilha é definido na criação,sempre adicionando ou removendo o útlimo elemento. 
 * Esta classe implementa a estrutura de dados pilha com um vetor estático, e generics para o tipo. 
 * 
 * @author Danti
 *
 * @param <T> O tipo dos itens que serão armazenados.
 */
public class Pilha<T> {

	protected Object vetor[];
	protected int count;
	
	/**
	 * Inicializa um objeto Pilha recém-criado, com o tamanho definido por parâmetro.
	 * 
	 * @param tamanho O espaço total da pilha.
	 */
	public Pilha(int tamanho) {
		vetor = new Object [tamanho];
		count = 0;
	}
	
	/**
	 * Inicializa um objeto Pilha recém-criado, com um espaço disponível.
	 */
	public Pilha() {
		vetor = new Object [1];
		count = 0;
	}

	/**
	 * Retorna o ultimo elemento da pilha.
	 * 
	 * @return O último item da pilha.
	 */
	@SuppressWarnings("unchecked")
	public T peek() throws ContainerEmptyException {
		if ( isEmpty() )
			throw new ContainerEmptyException();
		return (T) vetor [count - 1];
	}

	/**
	 * Adiciona um elemento na pilha.
	 * 
	 * @param T obj O elemento a ser inserido na pilha.
	 */
	public void push(T obj) {
		if ( count == vetor.length )
			aumentaPilha();
		vetor[count++] = obj;
	}

	/**
	 * Retira um elemento da pilha.
	 * 
	 * @return O elemento que foi retirado.
	 */
	@SuppressWarnings("unchecked")
	public T pop() throws ContainerEmptyException {
		if ( isEmpty() )
			throw new ContainerEmptyException ();
		T resultado = (T) vetor [--count];
		vetor [count] = null;
		return resultado;
	}

	/**
	 * Informa se a pilha está cheia.
	 * 
	 * @return Verdadeiro se estiver cheia, falso senão.
	 */
	public boolean isFull() {
		return count == vetor.length -1;
	}
	
	/**
	 * Informa se a pilha está vazia.
	 * 
	 * @return Verdadeiro se estiver vazia, falso senão.
	 */
	public boolean isEmpty() {
		return count == 0;
	}
	
	/**
	 * Aumenta o tamanho da pilha em um espaço.
	 */
	private void aumentaPilha() {
		Object[] tempVet = (Object[]) new Object[vetor.length + 1];

		System.arraycopy(this.vetor, 0, tempVet, 0, vetor.length);
		this.vetor = tempVet;
	}
}
