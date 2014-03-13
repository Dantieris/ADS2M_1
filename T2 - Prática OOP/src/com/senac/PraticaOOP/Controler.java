package com.senac.PraticaOOP;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Controler 
{
	private View view;
	
	public Controler()
	{
		view = new View();
		
	}
	
	//criando um objeto contato.
	//retorno Pessoa contato devolve um contato com nome, endereço e telefones.
	private Pessoa criarContato()
	{
		Pessoa contato = new Pessoa( view.recebeNome(), view.recebeEndereco(), view.recebeTelefones() );
		
		return contato;
	}
	
	//Lista um contato na tela
	public void listarContato()
	{
		Pessoa contato = criarContato();
		
		view.imprimeContato(contato.getNome(), contato.getEndereco(), contato.getTelefone());
	}
		
}
