package com.senac.applicacao;

import com.senac.controles.ConversorBases;
import com.senac.estruturas.exceptions.ContainerEmptyException;
import com.senac.estruturas.exceptions.ContainerFullException;

public class Aplicacao {
	
	public static void main(String[] args) {
		ConversorBases cb = new ConversorBases();
		
		try 
		{
			System.out.println(cb.converterDecimal());
		} 
		catch (ContainerFullException e) 
		{
			System.out.println( "Pilha cheia." );
		} 
		catch (ContainerEmptyException e) {
			System.out.println( "Pilha vazia." );			
		}
		
	}
}
