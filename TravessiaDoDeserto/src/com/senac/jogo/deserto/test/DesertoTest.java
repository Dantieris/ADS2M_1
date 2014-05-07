package com.senac.jogo.deserto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.deserto.Deserto;

public class DesertoTest {

	Deserto deserto;
	@Before
	public void setUp() throws Exception {
		deserto = new Deserto();
	}

	@After
	public void tearDown() throws Exception {
		deserto = null;
	}

	@Test
	public void testGetDistanciaEstadoInicialValorZero() {
		assertTrue( deserto.getDistancia() == 0 );
	}
	
	@Test
	public void testAddDistanciaAumentaValorNaDistancia() {
		deserto.addDistancia();
		
		assertTrue( deserto.getDistancia() == 1 );
	}
	
	@Test
	public void testDimDistanciaDiminuiValorNaDistanciaMaiorQueZero() {
		deserto.addDistancia();
		deserto.dimDistancia();
		
		assertTrue( deserto.getDistancia() == 0 );
	}
	
	@Test
	public void testAddDistanciaDuasVezesAumentaEmDoisDistancia() {
		deserto.addDistancia();
		deserto.addDistancia();
		
		assertTrue( deserto.getDistancia() == 2 );
	}

}
