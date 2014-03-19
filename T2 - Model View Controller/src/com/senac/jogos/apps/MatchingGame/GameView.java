package com.senac.jogos.apps.MatchingGame;

import java.util.Scanner;

import static java.lang.System.out;

public class GameView {

	private Scanner teclado = new Scanner(System.in);
	
	public String getUserInput()
	{
		return teclado.nextLine();
	}
	
	public void printLine(String mensagem)
	{
		System.out.println( mensagem );
	}
	
	public void mostraCarta(String numero, char naipe) {
		out.println(String.format("Carta: %s%c",
				                  numero,
				                  naipe));
	}
	
	public void mostraPontos(int pontos) {
		out.println(String.format("Pontos do jogador: %d",
				                  pontos));
	}
	
	//imprime a tabela da pontuacao final para quatro jogadores.
	//informando o vencedor, os pontos do vencedor,
	//e os potos dos outros jogadores.
	public void imprimeRank(int pontos1, int pontos2, int pontos3, int pontos4, int vencedor, int pontosVencedor)
	{
		out.printf("### Resultado ###%n"
				+ "Vencedor %d - %d Pontos%n"
				+ "-----------%n"
				+ "Jogador 1 %d Pontos%n"
				+ "Jogador 2 %d Pontos%n"
				+ "Jogador 3 %d Pontos%n"
				+ "Jogador 4 %d Pontos", vencedor, pontosVencedor
									, pontos1
									, pontos2
									, pontos3
									, pontos4);
	}
	
	//imprime a tabela da pontuacao final para tres jogadores.
	//informando o vencedor, os pontos do vencedor,
	//e os potos dos outros jogadores.
	public void imprimeRank(int pontos1, int pontos2, int pontos3, int vencedor, int pontosVencedor)
	{
		out.printf("### Resultado ###%n"
				+ "Vencedor %d - %d Pontos%n"
				+ "-----------%n"
				+ "Jogador 1 %d Pontos%n"
				+ "Jogador 2 %d Pontos%n"
				+ "Jogador 3 %d Pontos%n"
									, vencedor, pontosVencedor
									, pontos1
									, pontos2
									, pontos3);
	}
	
	//imprime a table da pontuacao final para dois jogadores.
	//informando o vencedor, os pontos do vencedor, 
	//e os pontos dos outros jogadores.
	public void imprimeRank(int pontos1, int pontos2, int vencedor, int pontosVencedor)
	{
		out.printf("### Resultado ###%n"
				+ "Vencedor %d - %d Pontos%n"
				+ "-----------%n"
				+ "Jogador 1 %d Pontos%n"
				+ "Jogador 2 %d Pontos%n"
									, vencedor, pontosVencedor
									, pontos1
									, pontos2);
	}
	
	//imprime a tabela de pontuação final para um jogador.
	//informando que é o vencedor e os seus pontos.
	public void imprimeRank(int pontos)
	{
		out.printf("### Resultado ###%n"
				+ "Vencedor %d - %d Pontos"
				+ "-----------%n"
				+ "Jogador 1 %d Pontos", pontos
									, pontos
									, pontos);
	}
		
}
