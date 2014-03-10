package com.senac.PraticaOOP;

public class Pessoa 
{
	private String nome;
	private String endereco;
	private String telefone[];
	
	public Pessoa(String nome, String endereco, String telefone[]) 
	{
		this.nome 				= nome;
		this.endereco 			= endereco;
		this.telefone 			= telefone;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public String getTelefone(int indice)
	{
		return telefone[indice];
	}
}
