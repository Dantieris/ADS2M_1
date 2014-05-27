package com.senac.estruturas.exceptions;

public class ContainerEmptyException extends Exception {

	private static final long serialVersionUID = -5560738211394980940L;

	public ContainerEmptyException() {
		super( "container empty" );
	}
}
