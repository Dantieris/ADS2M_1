package com.senac.controles;

import java.util.Scanner;

import com.senac.estruturas.Pilha;
import com.senac.estruturas.exceptions.ContainerFullException;

public class CalculadorExpressoes {
	
	private String converterPosFixa( String expressao ) {
		Scanner scan = new Scanner(expressao);
		Pilha<Character> pilha = new Pilha<Character>(20);
		StringBuffer saida = new StringBuffer();
		byte aspas = 0;
		
		while(scan.hasNext()) {
			String elemento = scan.next();
			
			if ( isNumber(elemento) ) 
				saida.append(elemento);	
			else {
				if ( isOperador(elemento) ) {
					if ( elemento.equals("\"") ) {
						try 
						{
							if ( aspas++ <= 0 )
								pilha.push(elemento.charAt(0));
							else {
								//desempilhar os elementos da pilha, e envie para a saida,
								//at� o operador ser o fecha aspas, que ser� descartado
							}
								
						} 
						catch (ContainerFullException e) {
							System.err.println( "Pilha cheia." );
						}
					}
					else {
						
					}
						
				}
				
			}
		}
		
		return null;
	}
	
	private boolean isNumber(String elemento) {
		return elemento.matches("[0-9]*"); 
	}

	/**
	 * Informa se uma String � um operador.
	 * 
	 * @param e
	 * @return
	 */
	private boolean isOperador( String e ) {
		switch( e ) {
		case "-": return true;
		case "+": return true;
		case "*": return true;
		case "/": return true;
		case "\"": return true;
		default : return false;
		}
	}
	
	private boolean isPrecedente( String a, String b ) {
		return false;
	}
	
}
