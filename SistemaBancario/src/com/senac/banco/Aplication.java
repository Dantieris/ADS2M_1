package com.senac.banco;

import com.senac.banco.system.Gerenciador;

public class Aplication 
{

	public static void main(String[] args) 
	{
		Gerenciador bancoGerenciador = new Gerenciador();
		
		bancoGerenciador.cadastrarCliente();
	}

}
