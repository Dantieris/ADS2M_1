package com.senac.jogo.deserto;

public class Deserto {

	private int distancia = 0;
	public int getDistancia() {
		return distancia;
	}

	public void addDistancia() {
		distancia++;
	}

	public void dimDistancia() {
		if ( getDistancia() > 0 )
			distancia -= 1;
	}

}
