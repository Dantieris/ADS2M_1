package com.senac.PraticaOOP;

public class ViewOutput 
{
	//imprime uma mensagem na tela.
	//parâmetro String mensagem é a mensagem que será imprimida.
	public void imprimeLinha(String mensagem)
	{
		System.out.println(mensagem);
	}
	
	//imprime o contato na tela em uma linha.
	//parâmetro String nome nome do contato, String endereco é o endereço do contato, 
	//e String telefones[] é um vetor que armazena três telefones do contato.
	public void imprimeContato(String nome, String endereco, String telefones[])
	{
		System.out.printf("Nome: %s - Endereço: %s - Celular: %s - Residencial %s - Comercial: %s" , nome, endereco,
																			telefones[0], telefones [1], telefones[2]);
	}
}
