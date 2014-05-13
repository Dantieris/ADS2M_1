package com.senac.jogo.jogo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.jogo.jogo.Jogo;

public class JogoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDescarregarDiminuiCargaDoCaminhaoEAddUnidadeNoDesertoGetCaminhaoGetDeserto() {
		Jogo jogo = new Jogo();
		
		jogo.descarregar();
		
		assertTrue( jogo.getCaminhao().getCargas() == 5 &&
					jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] == 1 );
	}
	
	@Test
	public void testDescarregarFalharComCaminhaoSemCargas() {
		Jogo jogo = new Jogo();
		
		for ( int i = 0 ; i < 7 ; i++)
			jogo.descarregar();
		
		assertFalse( jogo.getCaminhao().getCargas() < 0 ||
				jogo.getDeserto().getUnidades()[ jogo.getDeserto().getDistancia() ] > 6 );
	}
	
	
}
