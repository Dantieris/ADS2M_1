package com.senac.jogos;

public class Jogador {
	private int pontos;
	
	public Jogador() {
		pontos = 0;
	}
	public int getPontos() {
		return pontos;
	}
	public void addPontos(int pontos) {
		this.pontos += pontos;
	}
	public void subtractPontos(int pontos) {
		this.pontos -= pontos;
	}
}
