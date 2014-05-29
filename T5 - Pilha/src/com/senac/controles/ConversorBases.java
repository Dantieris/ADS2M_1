package com.senac.controles;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Converte um n�mero decimal para um n�mero bin�rio. 
 * Esta classe faz a convers�o de n�meros decimais positivos, em bin�rios, 
 * e retorna uma String com os n�meros bin�rios. 
 * A convers�o � implementada utilizando a estrutura de dados pilha.
 * 
 * @author Danti�ris Castilhos Rabelini
 * @version 1.0
 *
 */
public class ConversorBases {
	/**
	 * Inicializa um objeto ConversorBases rec�m-criado.
	 */
	public ConversorBases() {}
	
	/**
	 * Concatena os valores da pilha, retornando uma String.
	 * @param pilha A pilha que ser� retirado os valores.
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
	 * Converte um n�mero decimal em bin�rio, e retorna o bin�rio em uma String.
	 * @param decimal O n�mero a ser convertido.
	 * @return Uma String do n�mero bin�rio.
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
