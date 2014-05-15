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

	@SuppressWarnings("rawtypes")
	private ListaEncadeadaOrdenada lista;
	
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() throws Exception {
		lista = new ListaEncadeadaOrdenada();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public void testSetHeadNodoNulo() {
		lista.setHead(null);
		
		assertEquals( null, lista.getHead());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSetHeadNodoValido() {
		Nodo head = new Nodo();
		
		head.setValor("valor");
		lista.setHead( head );
		
		assertEquals( "valor", lista.getHead().getValor() );
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testInserirComListaVazia() {
		Nodo primeiro = new Nodo();

		lista.inserir( primeiro );
		
		assertTrue( lista.getHead().getNext() == primeiro );
	}
}



















