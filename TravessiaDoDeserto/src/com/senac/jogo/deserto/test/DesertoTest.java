package com.senac.jogo.deserto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.deserto.Deserto;

public class DesertoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDistanciaEstadoInicialValorZero() {
		Deserto deserto = new Deserto();
		
		assertTrue( deserto.getDistancia() == 0 );
	}

}
