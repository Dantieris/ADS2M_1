package com.senac.banco;

import com.senac.banco.sistema.Gerenciador;

public class Aplicacao 
{

	public static void main(String[] args) 
	{
		Gerenciador bancoGerenciador = new Gerenciador();
		
		bancoGerenciador.cadastrarCliente();
	}

}
