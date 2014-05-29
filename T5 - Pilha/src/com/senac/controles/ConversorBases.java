package com.senac.controles;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Converte um número decimal para um número binário. 
 * Esta classe faz a conversão de números decimais positivos, em binários, 
 * e retorna uma String com os números binários. 
 * A conversão é implementada utilizando a estrutura de dados pilha.
 * 
 * @author Dantiéris Castilhos Rabelini
 * @version 1.0
 *
 */
public class ConversorBases {
	/**
	 * Inicializa um objeto ConversorBases recém-criado.
	 */
	public ConversorBases() {}
	
	/**
	 * Concatena os valores da pilha, retornando uma String.
	 * @param pilha A pilha que será retirado os valores.
	 * @return Uma String contendo os valores da pilha.
	 */
	private String somaPilha( Pilha<Integer> pilha ) {
		StringBuffer total = new StringBuffer();
		
		while( !pilha.isEmpty() ) {
			try 
			{
				total.append(String.valueOf(pilha.pop()));
			} 
			catch (ContainerEmptyException e) {
				System.err.println( "Erro a pilha esta vazia." );
			}
		}
		
		return total.toString();
	}
	
	/**
	 * Converte um número decimal em binário, e retorna o binário em uma String.
	 * @param decimal O número a ser convertido.
	 * @return Uma String do número binário.
	 */
	public String converterDecimal( int decimal ) {
		Pilha<Integer> pilha = new Pilha<Integer>(31);
		
		while(decimal >= 2) {
			try 
			{
				pilha.push( decimal%2 );
			} 
			catch (ContainerFullException e) 
			{
				System.err.println( "Erro a pilha ficou cheia." );
			}
			decimal = decimal/2;
		}
		try 
		{
			pilha.push(decimal);
		} 
		catch (ContainerFullException e) {
			System.err.println( "Erro a pilha ficou cheia." );
		}
		
		return somaPilha(pilha);
	}
	
}
