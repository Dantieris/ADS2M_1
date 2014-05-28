package com.senac.controles;

import com.senac.console.Console;
import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Recebe uma string do usuário, compara e informa se é um palimdromo.
 * 
 * @author 631320025
 * 
 */
public class VerificadorPalindromo {

	private Pilha invertida;
	private Pilha normal;
	private Console view;
	
	 /**
	  * Inicializa um objeto VerificadorPalimdromo recém-criado.
	  */
	public VerificadorPalindromo() {
		view = new Console();
	}
	
	/**
	 * Compara dois objetos, retornando verdadeiro se são iguais, e falso senão.
	 * 
	 * @param a Primeiro objeto a ser comparado.
	 * @param b Segundo objeto a ser comparado.
	 * @return Verdadeiro se Object a é igual a Object b, senão retorna falso.
	 */
	private boolean comparaObjects(Object a, Object b) {
		return a == b;
	}
	
	/**
	 * Verifica se uma String é um palimdromo, retornando verdadeiro se for, e falso senão. 
	 * Recebe uma String do usuário, coloca a String em duas pilhas, e compara caracter por caractere.
	 * 
	 * @return Verdadeiro se for palimdromo, falso senão.
	 * @throws (@exception ContainerFullException) Se a pilha está cheia.
	 * @throws (@exception ContainerEmptyException) Se a pilha está vazia.
	 */
	public boolean verificaPalimdromo() throws ContainerFullException, ContainerEmptyException {
		boolean flag = false;
		view.printLine( "Digite o palimdromo: " );
		String palavra = inputString();
		
		normal = new Pilha(palavra.length());
		invertida = new Pilha(palavra.length());

		addNormal(palavra);
		addInvertida(palavra);
		
		for ( int i = 0 ; i < palavra.length() ; i++ ) {
			if ( comparaObjects( normal.pop() , invertida.pop()) )
				flag = true;
			else
				flag = false;
		}
		
		normal = null;
		invertida = null;
		
		return flag;
	}
	
	 /**
	  * Recebe uma String do usuário, e a retorna.
	  * 
	  * @return A String digitada pelo usuário.
	  */
	private String inputString() {
		return view.nextString();
	}
	
	/**
	 * Adiciona caractere por caractere de uma String na pilha, na ordem versa.
	 * 
	 * @param str String a ser inserida na pilha.
	 * @throws (@exception ContainerFullException) Se a pilha esta cheia.
	 */
	private void addNormal( String str ) throws ContainerFullException {
		for( int i = 0 ; i < str.length() ; i++ )
			normal.push(str.charAt(i));
	}
	
	/**
	 * Adiciona caractere por caractere de uma String na pilha, na ordem inversa.
	 * 
	 * @param str String a ser inserida na pilha.
	 * @throws (@exception ContainerFullException) Se a pilha esta cheia.
	 */
	private void addInvertida( String str ) throws ContainerFullException {
		for( int i = 0 ; i < str.length() ; i++ )
			invertida.push(str.charAt(i));
	}
}
