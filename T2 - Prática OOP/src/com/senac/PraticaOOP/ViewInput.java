package com.senac.PraticaOOP;

public class ViewInput 
{
	public String recebeLinha(String mensagem)
	{
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print(mensagem);
		String linha = input.nextLine();
		
		return linha;
	}	
}
