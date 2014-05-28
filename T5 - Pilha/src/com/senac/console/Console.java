package com.senac.console;

import java.util.Scanner;

public class Console {
	
	public String nextString() {
		return scanner().next().trim().toLowerCase();
	}
	
	public void printLine( String ms ) {
		System.out.println( ms );
	}

	private Scanner scanner() {
		return new Scanner(System.in);
	}
}
