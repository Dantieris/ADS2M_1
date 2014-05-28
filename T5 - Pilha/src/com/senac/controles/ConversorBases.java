package com.senac.controles;

import com.senac.console.Console;
import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Converte um número decimal para um número binário.
 * 
 * @author 631320025
 *
 */
public class ConversorBases {
	private int decimal;
	private Pilha pilha;
	private Console view;
	
	/**
	 * Inicializa um objeto ConversorBases com uma pilha de 5 espaços.
	 */
	public ConversorBases() {
		decimal = 0;
		pilha 	= new Pilha(5);
		view 	= new Console();
	}
	
	/**
	 * Inicializa um objeto ConversoBases com uma pilha de 5 espaços, e recebendo um número decimal.
	 * 
	 * @param decimal O número a ser convertido para binário.
	 */
	public ConversorBases( int decimal ) {
		this.decimal = decimal;
		pilha 		 = new Pilha(5);
		view		 = new Console();
	}
	
	/**
	 * Soma todos os valores da pilha, e retorna o valor tota.
	 * 
	 * @return O valor total da soma.
	 * @throws (@exception ContainerEmptyException) Se a pilha está vazia.
	 */
	private int somaPilha() throws ContainerEmptyException {
		int total = 0;
		for ( int i = 0 ; i < pilha.getCount() ; i++)
			total += (int) pilha.pop();
		return total;
	}
	
	/**
	 * Recebe um número decimal e retorna em binário.
	 * 
	 * @return
	 * @throws ContainerFullException
	 * @throws ContainerEmptyException
	 */
	public int converterDecimal() throws ContainerFullException, ContainerEmptyException {
		decimal = view.nextInt();
		
		while(decimal > 2) {
			if ( pilha.isFull() )
				aumentarPilha();
			pilha.push( decimal%2 );
			
			decimal = decimal/2;
		}
		
		return somaPilha();
	}
	
	/**
	 * Aumenta o tamanho da pilha.
	 * 
	 * @throws (@exception ContainerFullException) Se a pilha está cheia.
	 * @throws (@exception ContainerEmptyException) Se a pilha está vazia.
	 */
	private void aumentarPilha() throws ContainerFullException, ContainerEmptyException {
		Pilha nova = new Pilha( pilha.getCount() + 3 );
		
		for ( int i = 0 ; i < pilha.getCount() ; i++ )
			nova.push(pilha.pop());
		
		pilha = nova;
	}
	
}
