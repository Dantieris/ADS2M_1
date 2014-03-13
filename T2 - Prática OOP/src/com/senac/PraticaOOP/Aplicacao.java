package com.senac.PraticaOOP;

public class Aplicacao {

	public static void main(String[] args) {
		Controler controlador = new Controler();
		
		for ( int i = 0 ; i < 50 ; i++)
		{
			controlador.listarContato(controlador.gerarContatoAleatorio());
			System.out.println("");
		}
		
	}
	
}
