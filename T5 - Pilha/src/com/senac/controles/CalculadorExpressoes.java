package com.senac.controles;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.exceptions.ExpressaoInvalidaException;

/**
 * Esta classe representa um calculador de expressoes matematicas infixas. 
 * A implementacao é feita a partir da conversao da expressao infixa para a pos-fixa,
 * para ser calculada.
 * 
 * @author Dantieris Castilhos Rabelini
 *
 */
public class CalculadorExpressoes {
	
	/**
	 * Converte uma expressao matematica infixa em uma expressao pos-fixa.
	 * 
	 * @param expressao A expressao a ser convertida.
	 * @return A expressao pós-fixa.
	 * @throws ExpressaoInvalidaException Se a expressao conter algum erro.
	 */
	private String converterPosFixa( String expressao ) throws ExpressaoInvalidaException {
		Pilha<Character> pilha = new Pilha<Character>(20);
		StringBuffer saida = new StringBuffer();
		
		for ( int i = 0 ; i < expressao.length() ; i++ ) {
			char e = expressao.charAt(i);
			
			if ( e == '(' )
				pilha.push(e);
			
			if ( Character.isDigit(e))
				saida.append(e);
			
			
			if ( isOperador(e) ) {
				saida.append(":");
				try {
					if ( isPrecedente(e, pilha.peek()) && !pilha.isEmpty() )
						pilha.push(e);
					else {
						while( isPrecedente(pilha.peek(), e) && !pilha.isEmpty() ) {
							saida.append(":"+ pilha.pop());
						}
						pilha.push(e);
					}
				}
				catch ( ContainerEmptyException e2 ) {
					System.err.println( "Erro pilha vazia ao reorganizar operadores." );
				}
					
			}
			
			if ( e == ')' ) {
				try {
					while( pilha.peek() != '(' && !pilha.isEmpty() ) {
						saida.append(":"+ pilha.pop());
					}
					pilha.pop();
					
				}
				catch ( ContainerEmptyException e1 ) {
					System.err.println( "Erro ao retirar operadores da pilha." );
				}
			}
		}
		
		while( !pilha.isEmpty() ) {
			try {
				if ( pilha.peek() == '(')
					throw new ExpressaoInvalidaException( "Erro expressão inválida." );
				saida.append(pilha.pop());
			} catch (ContainerEmptyException e) {
				System.err.println( "Erro desempilhando." );
			}
		}
		
		return saida.toString();
	}
	
	/**
	 * Calcula uma expressão matemática infixa, retorna um resultado inteiro.
	 * Exemplo de expressão matemática nfixa:
	 * 
	 * ((1+1)*2)
	 * resultado = 4.
	 * 
	 * @param expressao A expressão a ser calculada.
	 * @return Resultado da expressão.
	 */
	public int calcularInfixa( String expressao ) {
		int resultado = 0;
		String posFixa[] = null;
		Pilha<String> pilha = new Pilha<String>(20);
		try {
			posFixa = converterPosFixa(expressao).split(":");
		} 
		catch (ExpressaoInvalidaException e) {
			System.err.println( "Erro expressão inválida." );
			return 0;
		}

		for ( int i = 0 ; i < posFixa.length ; i++ ) {
			String e = posFixa[i];
			
			if ( e.matches("[0-9]*"))
				pilha.push(e);
			
			if (isOperador(e.charAt(0))) {
				try {
					String calculo = String.valueOf(calculaOperacao( Integer.parseInt( pilha.pop() ),
																	 Integer.parseInt( pilha.pop() ), 
																	 e.charAt(0) ) );
					
					pilha.push(calculo);
				} 
				catch (ContainerEmptyException e1) {
					System.err.println( "Erro pilha vazia." );
				}
			}	
				
		}
		
		while (!pilha.isEmpty()) {
			try {
				resultado += Integer.parseInt(pilha.pop());
			} catch (ContainerEmptyException e) {
				System.err.println( "Erro pilha vazia." );
			}
		}
		
		return resultado;
	}
	
	/**
	 * Informa a se o operador A precede o operador B nas ordem das operações.
	 * 
	 * @param A Operador a verificar se é precedente.
	 * @param B Operador a verificar se é precedido.
	 * @return Verdadeiro se A precedir B, falso senão.
	 */
	private boolean isPrecedente( char A, char B ) {
		return getPrecedencia(A) >= getPrecedencia(B);
	}
	
	/**
	 * Calcula a precendencia do operador.
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
	* Informa se uma char é um operador.
	*
	* @param e Char a ser comparado.
	* @return Verdadeiro se for operador, falso senão.
	*/
	private boolean isOperador( char e ) {
		return (e == '-' || e == '+' || e == '/' || e == '*');
	}
	
	/**
	 * Calcula uma operação de acordo com o operador. Soma, subtração, divisão e multiplicação.
	 * 
	 * @param num1 Primeiro número a ser calculado.
	 * @param num2 Segundo número a ser calculado.
	 * @param operador Define a operação a ser feita.
	 * @return
	 */
	private int calculaOperacao(int num2, int num1, char operador) {
		switch( operador ) {
		case '-' : return num1-num2;
		case '+' : return num1+num2;
		case '*' : return num1*num2;
		case '/' : return num1/num2;
		default  : return 0;
		}
	}

}

