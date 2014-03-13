package com.senac.PraticaOOP;

public class Aplicacao {

	public static void main(String[] args) {
		Controler controlador = new Controler();
		
		//instruções para criar e imprimir 50 contatos.
		for ( int i = 0 ; i < 50 ; i++)
		{
			controlador.listarContato(controlador.gerarContatoAleatorio());
			System.out.println("");
		}
		
	}
	
}
