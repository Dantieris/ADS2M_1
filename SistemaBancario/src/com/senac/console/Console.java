package com.senac.console;

import java.util.Scanner;

public class Console 
{
	
	Scanner input = new Scanner( System.in );
	
	public String inputName()
	{
		printLine( "Enter your name: " );
		return input.nextLine();
	}
	
	public double inputBalance()
	{
		printLine( "Enter the account intial balance: " );
		return input.nextDouble();
	}
	
	public double inputLimit()
	{
		printLine( "Enter the account limit withdrawal: " );
		return input.nextDouble();
	}
	//recebe um numero inteiro
	//parametro String mensagem, a mensagem informa pro usuario qual numero deve digitar.
	//retorna um numero int.
	public int recebeNumeroInteiro( String mensagem )
	{
		printLine( mensagem );
		
		int numero = 0;
		
		try
		{
			String stringNumero = inputLine();
			
			numero = Integer.parseInt( stringNumero );
		}
		catch ( Exception e )
		{
			printErro( "O valor digitado é incompatível" );
		}
		
		return numero;
	}
	
	//imprime uma mensagem de erro,
	//parametro String mensagem, informa a mensagem a ser imprimida.
	public void printErro( String mensagem )
	{
		System.err.println( mensagem );
	}
	
	public String recebeTipoConta()
	{
		printLine( "Digite o tipo de conta: " );
		
		String tipo = inputWord();
		
		return tipo;
	}

	public void printLine( String message ) 
	{
		System.out.println( message );
		
	}

	public String inputLine() 
	{
		return input.nextLine();
	}
	
	public String inputWord()
	{
		return input.next();
	}

	public double inputDouble() 
	{
		return input.nextDouble();
	}

	public int inputInteger() 
	{
		return input.nextInt();
	}
	
}
