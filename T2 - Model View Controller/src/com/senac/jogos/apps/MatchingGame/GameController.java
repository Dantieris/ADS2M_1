package com.senac.jogos.apps.MatchingGame;

import com.senac.jogos.Jogador;
import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Carta;
import com.senac.jogos.rules.MatchingGame;

public class GameController {

	private MatchingGame game;
	private Baralho baralho;
	private Jogador[] jogador;
	private GameView view;
	
	public GameController() 
	{
		view 	= new GameView();
		baralho = new Baralho();
		game 	= new MatchingGame(baralho.drawCarta());
		jogador = new Jogador[ quantidadeJogadores() ];
		
		for (int i = 0 ; i < jogador.length ; i++)
			jogador[i] = new Jogador();
		
	}

	public Jogador[] getJogador()
	{
		return jogador;
	}

	//realiza uma joganda informando se uma das op��es foi escolhida
	//se nenhuma op��o tenha sido escolhida retorna FALSE, 
	//caso contrario retorna TRUE.
	public boolean realizaJogada(int numeroJogador) 
	{
		String op = view.getUserInput();
		
		if ( op.equalsIgnoreCase("jogar") ) 								//op��o de jogada "jogar".
		{																	
			
			Carta comprada = baralho.drawCarta();							//compra uma carta par ao usu�rio.
			
			view.mostraCarta( comprada.getNumero(), comprada.getNaipe() );	//mostra a carta comprada pelo jogador.
			
			int score = game.matchCards( comprada );						//calcula o valor de pontos recebidos pela jogada.
			jogador[numeroJogador].addPontos( score );						//adiciona esses valores a pontua��o do usu�rio.
			
			game.setMesa( comprada );										//coloca a carta comprada pelo usu�rio na mesa.
			
			jogador[ numeroJogador ].setPassouRodada(false);
			
			return true;
		}
		
		if ( op.equalsIgnoreCase("passar") 									//op��o de jogada "passar". Jogador nao pode passar a rodada
				&& !jogador[ numeroJogador ].isPassouRodada() )				
		{																	//duas vezes seguidas.
			jogador[ numeroJogador ].subtractPontos( 1 );					//dubtrai um ponto dos pontos do jogador.
			
			view.printLine( "Voc� passou a vez..." );						//informa que o usu�rio passou uma rodada.
			
			jogador[ numeroJogador ].setPassouRodada(true);
			
			return true;
		}
		
		else
			return false;
		
	}

	//informa se o baralho esta vazio.
	//valor TRUE se o paralho n�o tem cartas. Valor FALSE caso contrario.
	public boolean isOver() {
		return baralho.isEmpty();		
	}

	//informa o estado do jogador.
	//o n�mero do jogador, os seus pontos atuais e a carta comprada.
	public void showStatus(int numeroJogador) {
		view.printLine( "" );
		view.printLine( "Jogador n�mero " + (numeroJogador + 1) );
		view.mostraPontos(jogador[numeroJogador].getPontos());
		view.mostraCarta( game.getMesa().getNumero() , game.getMesa().getNaipe() );
	}
	
	//recebe a quantidade de jogadores participantes da partida.
	//m�nimo 1 e m�ximo 4.
	private int quantidadeJogadores()
	{
		view.printLine( "Digite a quantidade de jogadores: 1 a 4" );
		
		int quantidade = Integer.parseInt(view.getUserInput());
		
		return quantidade;
	}
	
}





