package com.senac.PraticaOOP;

public class View 
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
		
		//recebe um valor digitado pelo usuário.
		//retorna String linha é o valor digitado pelo usuário.
		public String recebeLinha()
		{
			java.util.Scanner input = new java.util.Scanner(System.in);
			String linha = input.nextLine();
			
			return linha;
		}
		
		//recebe um endereço
		//retorna String endereco texto digitado pelo usuário.
		public String recebeEndereco()
		{
			String endereco;
			
			imprimeLinha( "Digite o endereco: " );
			endereco = recebeLinha();
			
			return endereco;
		}
		
		//recebe um nome.
		//retorna String nome texto digitado pelo usuário.
		public String recebeNome()
		{
			String nome;
			
			imprimeLinha( "Digite o nome: " );
			nome = recebeLinha();
			
			return nome;
		}
		
		//recebe três números de telefone: celular, residencial e comercial.
		//retorna String[] telefone vetor com três strings de telefone.
		public String[] recebeTelefones()
		{
			String telefone[] = new String [3];
			
			imprimeLinha( "Digite o telefone celular: " );
			telefone [0] =  recebeLinha();
			
			imprimeLinha( "Digite o telefone residencial: " );
			telefone [1] = recebeLinha();
			
			imprimeLinha( "Digite o telefone comercial: " );
			telefone [2] = recebeLinha();
			
			return telefone;
		}
}
