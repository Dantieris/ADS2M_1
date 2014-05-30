package com.senac.controles;

import java.util.Scanner;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.exceptions.ExpressaoInvalidaException;

/**
 * Esta classe representa um calculador de expressoes matematicas infixas. 
 * A implementacao é feita a partir da conversao da expressao em pos-fixa,
 * para ser calculada nesta forma.
 * 
 * @author Dantieris Castilhos Rabelini
 *
 */
public class CalculadorExpressoes {
	
	/**
	 * Converte uma expressao matematica infixa em uma expressao pos-fixa.
	 * 
	 * @param expressao A expressao matematica infixa a ser convertida.
	 * @return Uma expressao matematica pos-fixa.
	 * @throws ExpressaoInvalidaException Se a expressao conter algum erro.
	 */
	@SuppressWarnings({ "unused", "resource" })
	private String converterPosFixa( String expressao ) throws ExpressaoInvalidaException {
		Scanner scan = new Scanner(expressao);
		Pilha<Character> pilha = new Pilha<Character>(20);
		StringBuffer saida = new StringBuffer();
		
		while(scan.hasNext()) {
			String elemento = scan.next();
			
			if ( isNumber(elemento) ) 
				saida.append(elemento);
			if ( isOperador(elemento.charAt(0))) {
				char e = elemento.charAt(0);
				
				if (e == '(')
					pilha.push(e);
				else {
					if (e == ')') {
						char operador = 0;
						do {
							try 
							{
								operador = pilha.pop();
								saida.append(operador);
							} 
							catch (ContainerEmptyException e1) {
								System.err.println( "Pilha vazia." );
							}
						} while( operador != ')' );
					}
				}
				
				try 
				{
					if ( isPrecedente(e, pilha.peek()) ) {
						pilha.push(e);
					}
					else {
						while( !isPrecedente(e, pilha.peek()) ) {
							saida.append(pilha.pop());
						}
						pilha.push(e);
					}
				} 
				catch (ContainerEmptyException e1) {
					System.err.println( "Pilha vazia." );
				}
			}

		}
		
		while ( !pilha.isEmpty() ) {
			char operador = 0;
			try 
			{
				operador = pilha.pop();
			} 
			catch (ContainerEmptyException e) {
				System.err.println( "Pilha vazia." );
			}
			
			if ( operador == ')' )
				throw new ExpressaoInvalidaException();
			saida.append(operador);
		}
		
		scan.close();
		return saida.toString();
	}
	
	/**
	 * Verifica se uma String é um numero, retorna verdadeiro se for, e falso senão.
	 * 
	 * @param elemento A String a ser testada.
	 * @return Verdadeiro se for numero, senão falso.
	 */
	private boolean isNumber(String elemento) {
		return elemento.matches("[0-9]*"); 
	}

	/**
	 * Informa se uma char é um operador.
	 * 
	 * @param e Char a ser comparado.
	 * @return Verdadeiro se for operador, falso senão.
	 */
	private boolean isOperador( char e ) {
		return (e == '-' || e == '+' || e == '(' || e == '/' || e == '*' || e == ')');
	}
	
	/**
	 * Verifica e informa se o operador a é precedente ao operador b. 
	 * Precedencia é o que define a ordem de calcular as operações.
	 * 
	 * @param operadorA
	 * @param OperadorB
	 * @return
	 */
	private boolean isPrecedente( char operadorA, char OperadorB ) {
		return getPrecedencia(operadorA) > getPrecedencia(OperadorB);
	}
	
	/**
	 * Calcula a precendencia de operadores do operador, e retorna este valor. 
	 * A precedencia define a ordem que serao calculados os operadores, 
	 * o maior é calculado antes do menor.
	 * 
	 * Operadores		 		Precedencia
	 * 
	 * Abre Parenteses ('(')	1
	 * Soma ('+')				2
	 * Subtracao ('-')	 		2
	 * Multiplicacao ('*')		3
	 * Divisao ('/')			3
	 * 
	 * @param operador O operador a ser calculada a precedencia.
	 * @return O valor da precedencia.
	 */
	private int getPrecedencia( char operador ) {
		int p = 0;
	    
		switch(operador)
		{
		case '(' : p = 1; break;
    	case '+' :
		case '-' : p = 2; break;
    	case '*' : 
		case '/' : p = 3;
		}
		
		return p;
	}
	
	/**
	 * Calcula uma expressao matematica infixa, retorna o resultado em um numero inteiro.
	 * 
	 * @param expressao A expressao a ser calculada.
	 * @return Resultado da expressao.
	 */
	public int calcularExpressao( String expressao ) {
		String posFixa = "";
		
		try {
			posFixa = converterPosFixa(expressao);
		} 
		catch (ExpressaoInvalidaException e) {
			System.err.println( "Erro expressão contém erro." );
		}
		
		Scanner entrada = new Scanner( posFixa );
		Pilha<Integer> pilha = new Pilha<Integer>();

		while( entrada.hasNext() ) {
			if ( entrada.hasNextInt() )
				pilha.push(entrada.nextInt());
			else {
				try 
				{
					pilha.push(pilha.pop() + pilha.pop());
				} 
				catch (ContainerEmptyException e) {
					System.err.println( "Pilha vazia." );
				}
			}
				
		}
		
		entrada.close();
		try {
			return pilha.pop();
		} catch (ContainerEmptyException e) {
			System.err.println( "Erro pilha vazia." );
		}
		
		return 0;
	}
	
}
