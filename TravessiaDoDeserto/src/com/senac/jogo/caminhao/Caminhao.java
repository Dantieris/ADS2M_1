package com.senac.jogo.caminhao;

public class Caminhao {

	private int cargas;
	
	public Caminhao() {
		cargas = 6;
	}
	
	public int getCargas() {
		return cargas;
	}

	public void dimCargas() {
		if ( cargas > 0 )
			cargas--;
	}

	public void addCargas() {
		if ( cargas < 6 )
			cargas++;
	}

}
