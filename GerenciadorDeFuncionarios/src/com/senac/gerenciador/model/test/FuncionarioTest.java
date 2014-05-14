package com.senac.gerenciador.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.gerenciador.model.Cargo;
import com.senac.gerenciador.model.Funcionario;

public class FuncionarioTest {

	private Funcionario estagiario;
	@Before
	public void setUp() throws Exception {
		estagiario = new Funcionario(Cargo.ESTAGIARIO, Cargo.ESTAGIARIO.getSalarioMinimo());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCriaFuncionarioMatriculaValidaGetMatricula() throws Exception {
		assertTrue( estagiario.getMatricula() > 0 );
	}

	@Test
	public void testCriaFuncionarioDoisFuncionariosNaoTemMesmaMatricula() throws Exception {
		Funcionario estagiario2 = new Funcionario(Cargo.ESTAGIARIO, 500.00);
		
		assertFalse( estagiario.getMatricula() == estagiario2.getMatricula() );
	}
	
	@Test
	public void testSalarioMenorQueMinimo() throws Exception {
		assertTrue( estagiario.getSalario() >= estagiario.getCargo().getSalarioMinimo() );
	}
	
	@Test(expected = java.lang.Exception.class)
	public void testCriarFuncionarioComSalarioMenorQueMinimoFalhar() throws Exception {
		new Funcionario(Cargo.ESTAGIARIO, 0);
	}
	
	@Test(expected = Exception.class)
	public void testAjusteSalarioNaoPodeDiminuir() throws Exception {
		estagiario.ajustaSalario(-5.0);
	}
	
	@Test
	public void testAjusteSalarioAjustaCorretamente() throws Exception {
		Funcionario funcionario = new Funcionario(Cargo.ESTAGIARIO, 1000.00);
		
		funcionario.ajustaSalario(4.20);
		
		assertEquals( 1042.00, funcionario.getSalario(), 0.00001);
	}
	
	@Test(expected=Exception.class)
	public void testAjusteSalarioNaoAumentaMenosQueDissidio() throws Exception {
		estagiario.ajustaSalario( estagiario.getCargo().getDissidio() - 0.001 );
	}
	
}
