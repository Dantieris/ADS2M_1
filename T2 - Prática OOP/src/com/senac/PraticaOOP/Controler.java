package com.senac.PraticaOOP;

public class Controler 
{
	private ViewOutput impressor;
	private ViewInput leitor;
	private View view;
	
	public Controler()
	{
		impressor 	= new ViewOutput();
		leitor 		= new ViewInput();
		
	}
	
	//criando um objeto contato.
	//retorno Pessoa contato devolve um contato com nome, endereço e telefones.
	public Pessoa criarContato()
	{
		Pessoa contato = new Pessoa( view.recebeNome(), view.recebeEndereco(), view.recebeTelefones() );
		
		return contato;
	}
	
}
