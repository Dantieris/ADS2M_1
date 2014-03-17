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
		
		if ( mesa.getNaipe() == comprada.getNaipe() )
			score = 1;
		if ( mesa.getNumero().equals( comprada.getNumero() ) )
			score = 4;
		
		return score;
	}
	
	//determina a pontuacao da jogada, 
	//de acordo com a equivalencia de valores da carta
	//determinado pela comparacao das cartas.
	public int matchCards(Carta comprada1, Carta comprada2)
	{
		int score = -3;
		
		//comparacao do naipe de duas cartas
		if ( compararDoisChars( mesa.getNaipe(), comprada1.getNaipe() ) )			
			score = 1;
		if ( compararDoisChars( mesa.getNaipe(), comprada2.getNaipe() ) )
			score = 1;
		if ( compararDoisChars( comprada1.getNaipe(), comprada2.getNaipe() ) )
			score = 1;
		
		//comparacao do numero de duas cartas
		if ( compararDuasStrings( mesa.getNumero(), comprada1.getNumero() ) )
			score = 3;
		if ( compararDuasStrings( mesa.getNumero(), comprada2.getNumero() ) )
			score = 3;
		if ( compararDuasStrings( comprada1.getNumero(), comprada2.getNumero() ) )
			score = 3;
		
		//comparacao de tres cartas
		if ( compararTresChars( mesa.getNaipe(), comprada1.getNaipe(), comprada2.getNaipe() ) )
			score = 6;
		if ( compararTresStrings( mesa.getNumero(), comprada1.getNumero(), comprada2.getNumero() ) )
			score = 8;
		
		return score;
	}
	
	//compara dois chares.
	//retorna TRUE se forem iguais, caso contrario retorna FALSE.
	private boolean compararDoisChars(char char1, char char2)
	{
		if ( char1 == char2)
		
			return true;
		else
			return false;				
	}
	
	//compara duas strings
	//retorna TRUE se forem iguais, caso contrario retorna FALSE.
	private boolean compararDuasStrings(String str1, String str2)
	{
		if ( str1.equals(str2) )
			return true;
		else
			return false;
	}
	
	//compara tres chares
	//retorna TRUE se forem iguais, caso contrario retorna FALSE.
	private boolean compararTresChars(char char1, char char2, char char3)
	{
		if ( char1 == char2 && char2 == char3)
			return true;
		else
			return false;
	}
	
	//compara tres strings
	//retorna TRUE se forem iguais, caso contrario retorna FALSE.
	private boolean compararTresStrings(String str1, String str2, String str3)
	{
		if ( str1.equals(str2) && str2.equals(str3))
			return true;
		else
			return false;
	}
	
	
}
