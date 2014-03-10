package com.senac.PraticaOOP;

public class ViewOutput 
{
	//imprime uma mensagem na tela.
	//par�metro String mensagem � a mensagem que ser� imprimida.
	public void imprimeLinha(String mensagem)
	{
		System.out.println(mensagem);
	}
	
	//imprime o contato na tela em uma linha.
	//par�metro String nome nome do contato, String endereco � o endere�o do contato, 
	//e String telefones[] � um vetor que armazena tr�s telefones do contato.
	public void imprimeContato(String nome, String endereco, String telefones[])
	{
		System.out.printf("Nome: %s - Endere�o: %s - Celular: %s - Residencial %s - Comercial: %s" , nome, endereco,
																			telefones[0], telefones [1], telefones[2]);
	}
}
