package com.senac.jogos.cartas;

public class Carta {
	private String numero;
	private char naipe;
	
	public Carta (String numero, char naipe)
	{
		this.numero = numero;
		this.naipe = naipe;
	}
	
	public String getNumero() {
		return this.numero;
	}
	public char getNaipe() {
		return this.naipe;
	}
}
