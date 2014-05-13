package com.senac.jogo.view;

import java.util.Scanner;

public class JogoView {

	private Scanner scanner;
	
	public JogoView() {
		scanner = new Scanner(System.in);
	}
	
	public void printLine( String mensagem ) {
		System.out.println( mensagem );
	}
	
	public String getStringLowCase() {
		return scanner.next().toLowerCase().trim();
	}
}
