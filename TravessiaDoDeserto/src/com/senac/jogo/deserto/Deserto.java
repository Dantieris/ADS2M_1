package com.senac.jogo.deserto;

public class Deserto {

	private int unidades[];
	private int distancia;
	
	public Deserto() {
		unidades = new int[10];
		distancia = 0;
	}
	
	public int getDistancia() {
		return distancia;
	}

	public void addDistancia() {
		if ( distancia < 10 )
			distancia++;
	}

	public void dimDistancia() {
		if ( getDistancia() > 0 )
			distancia -= 1;
	}

	public int[] getUnidades() {
		return unidades.clone();
	}

	public void addUnidade() {
		unidades[distancia]++;
	}
	
	public void dimUnidade() {
		if ( getUnidades()[distancia] > 0 )
			unidades[distancia]--;
	}
	
	

}
