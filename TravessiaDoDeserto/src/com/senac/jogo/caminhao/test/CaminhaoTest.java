package com.senac.jogo.caminhao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.caminhao.Caminhao;

public class CaminhaoTest {

	private Caminhao caminhao;
	@Before
	public void setUp() throws Exception {
		caminhao = new Caminhao();
	}

	@After
	public void tearDown() throws Exception {
		caminhao = null;
	}

	@Test
	public void testGetCargasRetornaSeisInicioJogo() {
		assertEquals( 6, caminhao.getCargas());
	}
	
	@Test
	public void testDescarregarDiminuiUmaCargaCaminhao() {
		caminhao.descarregar();
		
		assertEquals( 5, caminhao.getCargas());
	}
	
	@Test
	public void testDescarregarDuasVezesDiminuiDuasCargasCaminhao() {
		caminhao.descarregar();
		caminhao.descarregar();
		
		assertEquals( 4,  caminhao.getCargas());
	}
	
	@Test
	public void testDescarregarFalharAoDescarregarComZeroCargas() {
		for (int i = 0 ; i < 7 ; i++)
			caminhao.descarregar();
		
		assertFalse( caminhao.getCargas() < 0 );
	}

	@Test
	public void testCarregarCargaAumentaUmaCargaQuandoCargaMenorQueSeis() {
		caminhao.descarregar();
		caminhao.carregar();
		
		assertEquals( 6 , caminhao.getCargas());
	}
	
	@Test
	public void testCarregarDuasVezesAumentaDuasCargasComCargasZero() {
		for ( int i = 0; i < 6 ; i++ )
			caminhao.descarregar();
		
		caminhao.carregar();
		caminhao.carregar();

		assertEquals( 2, caminhao.getCargas());
	}
	
}





