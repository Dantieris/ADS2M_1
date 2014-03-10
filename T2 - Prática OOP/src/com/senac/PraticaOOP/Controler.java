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

	//recebe três números de telefone: celular, residencial e comercial.
	//retorno String[] telefone vetor com três strings de telefone.
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
	//retorno String nome texto digitado pelo usuário.
	public String recebeNome()
	{
		String nome;
		
		impressor.imprimeLinha( "Digite o nome: " );
		nome = leitor.recebeLinha();
		
		return nome;
	}
	
	//recebe um endereço
	//retorno String endereco texto digitado pelo usuário.
	public String recebeEndereco()
	{
		String endereco;
		
		impressor.imprimeLinha( "Digite o endereco: " );
		endereco = leitor.recebeLinha();
		
		return endereco;
	}
	
	//criando um objeto contato.
	//retorno Pessoa contato devolve um contato com nome, endereço e telefones.
	public Pessoa criarContato()
	{
		Pessoa contato = new Pessoa( recebeNome(), recebeEndereco(), recebeTelefones() );
		
		return contato;
	}
	
}
