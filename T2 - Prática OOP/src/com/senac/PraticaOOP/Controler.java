package com.senac.PraticaOOP;

public class Controler 
{
	private ViewOutput impressor;
	private ViewInput leitor;
	
	public Controler()
	{
		impressor 	= new ViewOutput();
		leitor 		= new ViewInput();
		
	}

	//recebe tr�s n�meros de telefone: celular, residencial e comercial.
	//retorno String[] telefone vetor com tr�s strings de telefone.
	public String[] recebeTelefones()
	{
		String telefone[] = new String [3];
		
		impressor.imprimeLinha( "Digite o telefone celular: " );
		telefone [0] =  leitor.recebeLinha();
		
		impressor.imprimeLinha( "Digite o telefone residencial: " );
		telefone [1] = leitor.recebeLinha();
		
		impressor.imprimeLinha( "Digite o telefone comercial: " );
		telefone [2] = leitor.recebeLinha();
		
		return telefone;
	}
}
