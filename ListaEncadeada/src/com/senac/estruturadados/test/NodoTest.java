package com.senac.estruturadados.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.estruturadados.Nodo;

public class NodoTest {

	private Nodo nodulo;
	@Before
	public void setUp() throws Exception {
		nodulo = new Nodo();
	}

	@After
	public void tearDown() throws Exception {
		nodulo = null;
	}

	@Test
	public void testSetValorUmGetValor() {
		nodulo.setValor( 1 );
		
		assertEquals( 1 , nodulo.getValor());
	}
	
	@Test
	public void testSetValorZeroGetValor() {
		nodulo.setValor( 0 );
		
		assertEquals( 0 , nodulo.getValor());
	}
	
	@Test
	public void testGetValorRetornarNuloInicioDaAplicacao() {
		assertEquals( null , nodulo.getValor());
	}
	
	@Test
	public void testSetValorMaiorQueZero() {
		nodulo.setValor(10);
		
		assertEquals( 10, nodulo.getValor());
	}
	
	@Test
	public void testSetValorMenorQueZero() {
		nodulo.setValor(-10);
		
		assertEquals( -10, nodulo.getValor());
	}
	
	@Test
	public void testSetValorString() {
		nodulo.setValor( "String" );
		
		assertEquals( "String" , nodulo.getValor());
	}

}







