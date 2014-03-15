package com.senac.jogos.apps.MatchingGame;

import com.senac.jogos.Jogador;
import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Carta;
import com.senac.jogos.rules.MatchingGame;

public class GameController {

	private MatchingGame game;
	private Baralho baralho;
	public Jogador[] jogador;
	private GameView view;
	
	public GameController() {
		view = new GameView();
		baralho = new Baralho();
		game = new MatchingGame(baralho.drawCarta());
		jogador = new Jogador[quantidadeJogadores()];
		
		for (int i = 0 ; i < jogador.length ; i++)
			jogador[i] = new Jogador();
	}
	
	public Jogador[] getJogador()
	{
		return jogador;
	}

	public void realizaJogada(int numeroJogador) {
		if (view.getUserInput().equalsIgnoreCase("jogar")) {
			Carta comprada = baralho.drawCarta();
			view.mostraCarta(comprada);
			int score = game.matchCards(comprada);
			jogador[numeroJogador].addPontos(score);
			game.setMesa(comprada);
		}
	}

	public boolean isOver() {
		view.printLine( "faltam " + baralho.numCartas );
		return baralho.isEmpty();		
	}

	public void showStatus(int numeroJogador) {
		view.printLine( "Jogador número " + (numeroJogador + 1) );
		view.mostraPontos(jogador[numeroJogador].getPontos());
		view.mostraCarta(game.getMesa());
	}
	
	private int quantidadeJogadores()
	{
		view.printLine( "Digite a quantidade de jogadores: 1 a 4" );
		
		int quantidade = Integer.parseInt(view.getUserInput());
		
		return quantidade;
	}
	
}





