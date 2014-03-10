package com.senac.PraticaOOP;

public class ViewInput 
{
	//recebe um valor digitado pelo usuário.
	//retorno String linha é o valor digitado pelo usuário.
	public String recebeLinha()
	{
		java.util.Scanner input = new java.util.Scanner(System.in);
		String linha = input.nextLine();
		
		return linha;
	}	
}
