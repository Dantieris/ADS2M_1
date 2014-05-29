package com.senac.controles;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Verifica se uma palavra é um palimdromo. 
 * Esta classe implementa a comparação utilizando uma pilha de caracteres, 
 * a comparação é feita char por char.
 * 
 * @author Dantiéris Castilhos Rabelini
 * 
 */
public class VerificadorPalindromo {
	
	/**
	 * Compara dois caracteres, retornando verdadeiro se forem iguais, e falso senão.
	 * 
	 * @param a Primeiro char a ser comparado.
	 * @param b Segundo char a ser comparado.
	 * @return Verdadeiro se a é igual a b, senão retorna falso.
	 */
	private boolean comparaCaractere(char a, char b) {
		return a == b;
	}
	
	/**
	 * Verifica se uma palavra é um palimdromo, retornando verdadeiro se for, e falso senão. 
	 * Este método implementa a comparação utilizando a estrutura pilha
	 * 
	 * @param palavra A palavra a ser verificada.
	 * @return Verdadeiro se for palimdromo, falso senão.
	 */
	public boolean verificaPalimdromo( String palavra ) {
		Pilha<Character> pilha = new Pilha<Character>(palavra.length());
		
		empilharPalavra(palavra, pilha);
		
		for ( int i = 0 ; i < palavra.length() ; i++ ) {
			try 
			{
				if ( !comparaCaractere( (char) pilha.pop() , palavra.charAt(i)) )
					return false;
			} 
			catch (ContainerEmptyException e) {
				System.err.println( "Pilha vazia." );
			}
		}
		
		return true;
	}
	
	/**
	 * Adiciona char por char da palavra na pilha.
	 * 
	 * @param palavra Palavra a ser inserida.
	 * @param pilha Pilha que irá armazenar os caracteres.
	 */
	private void empilharPalavra( String palavra, Pilha<Character> pilha ) {
		for( int i = 0 ; i < palavra.length() ; i++ ) {
			try 
			{
				pilha.push(palavra.charAt(i));
			} 
			catch (ContainerFullException e) {
				System.err.println( "Pilha cheia." );
			}
		}
	}

}
