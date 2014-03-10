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
	
	//recebe um nome.
	//retorno String nome texto digitado pelo usu�rio.
	public String recebeNome()
	{
		String nome;
		
		impressor.imprimeLinha( "Digite o nome: " );
		nome = leitor.recebeLinha();
		
		return nome;
	}
	
	//recebe um endere�o
	//retorno String endereco texto digitado pelo usu�rio.
	public String recebeEndereco()
	{
		String endereco;
		
		impressor.imprimeLinha( "Digite o endereco: " );
		endereco = leitor.recebeLinha();
		
		return endereco;
	}
	
	//criando um objeto contato.
	//retorno Pessoa contato devolve um contato com nome, endere�o e telefones.
	public Pessoa criarContato()
	{
		Pessoa contato = new Pessoa( recebeNome(), recebeEndereco(), recebeTelefones() );
		
		return contato;
	}
	
}
