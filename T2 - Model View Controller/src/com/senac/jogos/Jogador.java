package com.senac.jogos;

public class Jogador {
	private int pontos;				//armazena a quantidade de pontos
	private boolean passouRodada;	//informa se o jogador passou a rodada ou não.
	
	public Jogador() {
		pontos 			= 0;
		passouRodada 	= false;
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
	public boolean isPassouRodada() {
		return passouRodada;
	}
	public void setPassouRodada(boolean passouRodada) {
		this.passouRodada = passouRodada;
	}
	
}
