package com.senac.jogo.jogo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.jogo.Jogo;

public class JogoTest {

	private Jogo jogo;
	@Before
	public void setUp() throws Exception {
		jogo = new Jogo();
	}

	@After
	public void tearDown() throws Exception {
		jogo = null;
	}

	@Test
	public void testDescarregarDiminuiCargaDoCaminhaoEAddUnidadeNoDesertoGetCaminhaoGetDeserto() {
		jogo.descarregar();
		
		assertTrue( jogo.getCaminhao().getCargas() == 5 &&
					jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] == 1 );
	}
	
	@Test
	public void testDescarregarFalharComCaminhaoSemCargas() {
		for ( int i = 0 ; i < 7 ; i++)
			jogo.descarregar();
		
		assertFalse( jogo.getCaminhao().getCargas() < 0 ||
				jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] > 6 );
	}
	
	@Test
	public void testCarregarAumentarCargaCaminhaoDimUnidadeDeserto() {
		for ( int i = 0 ; i < 6 ; i++ )
			jogo.descarregar();
		
		jogo.carregar();
		
		assertTrue( jogo.getCaminhao().getCargas() == 1 && 
					jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] == 5 );
	}
	
	@Test
	public void testCarregarFalarComCaminhaoCarregado() {	
		jogo.carregar();
		
		assertFalse( jogo.getCaminhao().getCargas() > 6 || 
					jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] > 0 );
	}
}
