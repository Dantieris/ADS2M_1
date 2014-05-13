package com.senac.jogo.jogo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}
