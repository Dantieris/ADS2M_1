package com.senac.jogos.rules;

import com.senac.jogos.cartas.Carta;

public class MatchingGame {

	private Carta mesa;
	
	public MatchingGame(Carta inicial) {
		mesa = inicial;
	}

	public void setMesa(Carta mesa)
	{
		this.mesa = mesa;
	}
	
	public Carta getMesa()
	{
		return mesa;
	}
	
	public int matchCards(Carta comprada)
	{
		int score = -2;
		
		if (mesa.getNaipe() == comprada.getNaipe())
			score = 1;
		if (mesa.getNumero().equals(comprada.getNumero()))
			score = 4;
		
		return score;
	}
}
