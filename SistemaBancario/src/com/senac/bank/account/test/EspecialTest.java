package com.senac.bank.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.bank.account.Especial;
import com.senac.bank.exceptions.SaldoInsuficienteException;

/**
 * Classe de testes da classe Especial.
 * 
 * @author Danti
 *
 */
public class EspecialTest {

	private Especial conta;
	@Before
	public void setUp() throws Exception{
		conta = new Especial(1000);
	}
	
	@After
	public void setDown() throws Exception {
		conta = null;
	}
	@Test
	public void testGetLimite() {
		assertEquals( 1000 ,  conta.getLimite(), 0 );
	}
	
	@Test
	public void testSacarValorLimiteSemSaldoDisponivel() throws SaldoInsuficienteException {
		conta.sacar(1000);
		
		assertEquals(-1000, conta.getBalance(), 0);
	}

	@Test
	public void testGetTypeRetornaEspecial() {
		Especial conta = new Especial(1);
		
		assertTrue( conta.getType() == "Especial" );
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroESaldoNaCriacao() {
		Especial conta = new Especial(1000, 500, 100);
		
		assertTrue( conta.getAccountNumber() == 1000 && conta.getBalance() == 500 );		
	}
}
