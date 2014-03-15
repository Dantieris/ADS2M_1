package com.senac.jogos.apps.MatchingGame;

public class MatchingGame {

	public static void main(String[] args) {
		GameController game = new GameController();
		while (! game.isOver()) {
			
			for (int i = 0 ; i < game.getJogador().length ; i++)
			{
				if (game.isOver())
					break;
				game.showStatus(i);
				game.realizaJogada(i);
			}
			
		}
		
	}

}
