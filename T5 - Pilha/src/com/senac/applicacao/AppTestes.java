package com.senac.applicacao;

import com.senac.controles.CalculadorExpressoes;
import com.senac.controles.ConversorBases;
import com.senac.controles.VerificadorPalindromo;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

/**
 * Classe que realiza os testes das aplicações: Conversor de bases, 
 * verificador de palimdromos, e calculador de expressões matemáticas infixas.
 * 
 * @author Danti
 *
 */
public class AppTestes {
	
	public static void main(String[] args) {
		while ( true ) {
			menu();
		}
	}
	
	private static void conversorBasesTest() {
		ConversorBases cb = new ConversorBases();
		
		System.out.println( "Digite o número decimal:" );
		System.out.println( cb.converterDecimal( new java.util.Scanner(System.in).nextInt() ) );
	}
	
	private static void verificadorPalimdromoTest() {
		VerificadorPalindromo vp = new VerificadorPalindromo();
		
		System.out.println( "Digite a palavra:" );
		System.out.println( vp.verificaPalimdromo( new java.util.Scanner(System.in).next() ) );
	}
	
	private static void calculadorExpressoesTest() {
		CalculadorExpressoes ce = new CalculadorExpressoes();
		
		System.out.println( "Digite a expressao infixa:" );
		System.out.println( ce.calcularExpressao( new java.util.Scanner(System.in).next() ) );
	}
	
	private static void menu() {
		char op = 0;
		
		while( op != 's' ) {
			System.out.println( "\n=== Menu de Testes ==="
					+ "\n1 - Teste Conversor de Bases."
					+ "\n2 - Teste Verificaodr de Palindromos."
					+ "\n3 - Teste Calculador de Expressoes Matematicas Infixas."
					+ "\ns - Sair.");
			
			op = new java.util.Scanner(System.in).next().charAt(0);
			
			switch( op ) {
			case '1' : conversorBasesTest(); break;
			case '2' : verificadorPalimdromoTest(); break;
			case '3' : calculadorExpressoesTest(); break;
			default  : System.out.println( "Opção inválida" );
			}
		}
	}
}
