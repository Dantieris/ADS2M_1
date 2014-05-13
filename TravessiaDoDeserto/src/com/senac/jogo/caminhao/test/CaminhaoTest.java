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
	public void testDimCargasDiminuiUmaCargaCaminhao() {
		caminhao.dimCargas();
		
		assertEquals( 5, caminhao.getCargas());
	}
	
	@Test
	public void testDimCargasDuasVezesDiminuiDuasCargasCaminhao() {
		caminhao.dimCargas();
		caminhao.dimCargas();
		
		assertEquals( 4,  caminhao.getCargas());
	}
	
	@Test
	public void testDimCargasFalharAoDescarregarComZeroCargas() {
		for (int i = 0 ; i < 7 ; i++)
			caminhao.dimCargas();
		
		assertFalse( caminhao.getCargas() < 0 );
	}

	@Test
	public void testAddCargasAumentaUmaCargaQuandoCargaMenorQueSeis() {
		caminhao.dimCargas();
		caminhao.addCargas();
		
		assertEquals( 6 , caminhao.getCargas());
	}
	
	@Test
	public void testAddCargasDuasVezesAumentaDuasCargasComCargasZero() {
		for ( int i = 0; i < 6 ; i++ )
			caminhao.dimCargas();
		
		caminhao.addCargas();
		caminhao.addCargas();

		assertEquals( 2, caminhao.getCargas());
	}
	
}
