package com.senac.PraticaOOP;

public class ViewInput 
{
	//recebe um valor digitado pelo usu�rio.
	//retorno String linha � o valor digitado pelo usu�rio.
	public String recebeLinha()
	{
		java.util.Scanner input = new java.util.Scanner(System.in);
		String linha = input.nextLine();
		
		return linha;
	}	
}
