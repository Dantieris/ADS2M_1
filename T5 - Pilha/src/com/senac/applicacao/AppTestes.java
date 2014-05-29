package com.senac.applicacao;

import com.senac.controles.ConversorBases;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Classe que realiza os testes das aplica��es: Conversor de bases, 
 * verificador de palimdromos, e calculador de express�es matem�ticas infixas.
 * 
 * @author Danti
 *
 */
public class AppTestes {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ConversorBases cb = new ConversorBases();
		
		while(true) {
			System.out.println( "Digite o n�mero decimal:" );
			System.out.println( cb.converterDecimal( new java.util.Scanner(System.in).nextInt() ) );
		}
		
	}
}
