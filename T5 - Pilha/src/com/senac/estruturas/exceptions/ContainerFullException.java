package com.senac.estruturas.exceptions;

public class ContainerFullException extends Exception {

	private static final long serialVersionUID = 4207360859667789157L;

	public ContainerFullException() {
		super( "container full" );
	}
}
