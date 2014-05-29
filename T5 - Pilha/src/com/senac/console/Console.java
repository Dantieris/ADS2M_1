package com.senac.console;

import java.util.Scanner;

/**
 * Imprime mensagens na tela, e recebe informações digitadas pelo usuário.
 * 
 * @author Dantiéris Castilhos Rabelini
 * @version 1.0
 */
public class Console {
	
	/**
	 * Recebe uma String digitada pelo usuário, e a retorna.
	 * 
	 * @return A próxima String digitada.
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
	 * Recebe um número inteiro digitado pelo usuário.
	 * 
	 * @return O número digitado.
	 */
	public int nextInt() {
		return scanner().nextInt();
	}

}
