/**
 * 
 */
package com.senac.estruturadados.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.estruturadados.ListaEncadeadaOrdenada;
import com.senac.estruturadados.Nodo;

public class ListaEncadeadaOrdenadaTest {

	private ListaEncadeadaOrdenada<String> lista;
	
	@Before
	public void setUp() throws Exception {
		lista = new ListaEncadeadaOrdenada<String>();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	/**
	 * Definir head como nulo é o mesmo que limpar a lista.
	 */
	@Test
	public void testSetHeadNodoNulo() {
		lista.setHead(null);
		
		assertEquals( null, lista.getHead());
	}
	
	/**
	 * Inserindo um nodo na lista.
	 */
	@Test
	public void testSetHeadNodoValido() {
		Nodo<String> head = new Nodo<String>();
		
		head.setValor("valor");
		lista.setHead( head );
		
		assertEquals( "valor", lista.getHead().getValor() );
	}

	/**
	 * Inserindo o primeiro Nodo.
	 */
	@Test
	public void testInserirComListaVazia() {
		Nodo<String> primeiro = new Nodo<String>();

		lista.inserir( primeiro );
		
		assertTrue( lista.getHead() == primeiro );
	}
	
	/**
	 * Inserindo o segundo Nodo.
	 */
	@Test
	public void testInserirSegundoNodo() {
		
	}
}



















