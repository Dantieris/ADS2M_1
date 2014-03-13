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
	
	//Formata uma string telefone de 7 dígitos
	// em (00)XXX-XXXX.
	private String formatarTelefone(String telefone)
	{
		String prefixo = (String) telefone.subSequence(0, 4);
		String sufixo  = (String) telefone.subSequence(4, telefone.length());
		
		String telefoneFormatado = "(00)" + prefixo + "-" + sufixo;
		
		return telefoneFormatado;
	}
	
	//Formata uma string telefone de 9 dígitos
	// em (XX)XXX-XXXX.
	private String formatarTelefoneOperadora(String telefone)
	{
		String operadora = (String) telefone.subSequence(0, 2);
		String prefixo   = (String) telefone.subSequence(2, 5);
		String sufixo    = (String) telefone.subSequence(5, telefone.length());
		
		String telefoneFormatado = "(" + operadora + ")" + prefixo + "-" + sufixo;
		
		return telefoneFormatado;
	}
		
}
