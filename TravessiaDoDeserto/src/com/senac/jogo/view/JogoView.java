package com.senac.jogo.view;

import java.util.Scanner;

public class JogoView {

	public void printLine( String mensagem ) {
		System.out.println( mensagem );
	}
	
	public String getStringLowCase() {
		return scanner().next().toLowerCase().trim();
	}
	
	private Scanner scanner() {
		return new Scanner(System.in);
	}
}
