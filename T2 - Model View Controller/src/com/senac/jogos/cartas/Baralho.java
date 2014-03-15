package com.senac.jogos.cartas;

public class Baralho {
	
	private Carta[] cartas;
	public int numCartas;
	
	public Baralho() {
		char[] naipes = {'C','O','P','E'};
		String[] numeros = {"A" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "J" ," Q" , "K"};
		
		cartas = new Carta[52];
		numCartas = 0;
		
		for (char naipe: naipes ) {
			for (int i = 0 ; i < numeros.length ; i++) {
				cartas[numCartas] = new Carta(numeros[i], naipe);
				numCartas++;
			}
		}
		
	}
	
	public Carta drawCarta() {
		Carta carta = null;
		
		int indice = (int)(Math.random() * numCartas);
		carta = cartas[indice];
		numCartas--;
		cartas[indice] = cartas[numCartas];
		
		return carta;
	}

	public boolean isEmpty() {
		return numCartas == 0;
	}
}
