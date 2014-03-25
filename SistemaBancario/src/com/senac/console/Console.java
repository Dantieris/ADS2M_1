package com.senac.console;

public class Console extends Interface
{
	//recebe um numero fracionario
	//parametro String mensagem, a mensagem informa pro usuario qual numero deve digitar.
	//retorna um numero double.
	public double recebeNumeroDouble( String mensagem )
	{
		imprimeLinha( mensagem );
		
		double numero = 0;
		
		try
		{
			String stringNumero =  recebeLinha();
			
			numero = Double.parseDouble( stringNumero );
			
		}
		catch ( Exception e )
		{
			printErro( "O valor digitado é incompatível" );
		}
		
		return numero;
	}
	
	//recebe um numero inteiro
	//parametro String mensagem, a mensagem informa pro usuario qual numero deve digitar.
	//retorna um numero int.
	public int recebeNumeroInteiro( String mensagem )
	{
		imprimeLinha( mensagem );
		
		int numero = 0;
		
		try
		{
			String stringNumero = recebeLinha();
			
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
	
}
