package com.senac.console;

import java.util.Scanner;

public class Console {
	
	/**
	 * Recebe uma String digitada pelo usu�rio, e a retorna.
	 * 
	 * @return A pr�xima String digitada.
	 */
	public String nextString() {
		return scanner().next().trim().toLowerCase();
	}
	
	/**
	 * Imprime uma mensagem na tela.
	 * 
	 * @param ms A mensagem a ser impressa.
	 */
	public void printLine( String mensagem ) {
		System.out.println( mensagem );
	}

	/**
	 * Retorna um objeto Scanner.
	 * 
	 * @return O objeto Scanner.
	 */
	private Scanner scanner() {
		return new Scanner(System.in);
	}

	/**
	 * Recebe um n�mero inteiro digitado pelo usu�rio, e o retorna.
	 * 
	 * @return O n�mero digitado.
	 */
	public int nextInt() {
		return scanner().nextInt();
	}

}
