package com.senac.PraticaOOP;

public class Pessoa 
{
	private String nome;
	private String endereco;
	private String telefone[];
	
	public Pessoa(String nome, String endereco, String telefone, int ind) 
	{
		this.nome 			= nome;
		this.endereco 		= endereco;
		this.telefone[ind] 	= telefone;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public String getTelefone(int ind)
	{
		return telefone[ind];
	}
}
