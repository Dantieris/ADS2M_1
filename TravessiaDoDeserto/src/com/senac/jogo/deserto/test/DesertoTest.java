package com.senac.jogo.deserto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.deserto.Deserto;

public class DesertoTest {

	private Deserto deserto;
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
	
	@Test
	public void testDimDistanciaFalharAoDiminuirDistanciaNaPosicaoInicial() {
		deserto.dimDistancia();
		
		assertFalse( deserto.getDistancia() == -1 );
	}
	
	@Test
	public void testAddDistanciaFalharAoPassarDezDistancias() {
		for ( int i = 0 ; i < 11 ; i++ )
			deserto.addDistancia();
		assertFalse( deserto.getDistancia() > 10 );
	}
	
	@Test
	public void testGetUnidadesPossuiDezPosicoesDisponiveis() {
		assertTrue( deserto.getUnidades().length == 10 );
	}
	
	@Test
	public void testAddUnidadeAumentaValorNaPosicaoAtual() {
		deserto.addUnidade();
		
		assertEquals( 1, deserto.getUnidades()[ deserto.getDistancia() ]);
	}
	
	@Test
	public void testDimUnidadeDiminuiValorNaPosicaoAtual() {
		deserto.addUnidade();
		deserto.dimUnidade();
		
		assertEquals( 0 , deserto.getUnidades()[ deserto.getDistancia() ]);
	}
	
	@Test
	public void testDimUnidadeFalhaAoDiminuitValorAtualSendoZero() {
		deserto.dimUnidade();
		
		assertFalse( deserto.getUnidades()[deserto.getDistancia()] < 0 );
	}

}

