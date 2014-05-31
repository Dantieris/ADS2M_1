package com.senac.bank.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.bank.account.Investimento;

/**
 * Classe de testes da classe Investimento.
 * 
 * @author Danti
 *
 */
public class InvestimentoTest {

	private Investimento conta;
	@Before
	public void setUp() throws Exception {
		conta = new Investimento();
	}
	
	@After
	public void setDown() throws Exception {
		conta = null;
	}
	@Test
	public void testGerarDividendos() {
		conta.depositar(100);
		conta.dividendos(10);
		
		assertEquals( 110, conta.getBalance(), 0);
	}
	
	@Test
	public void testGetDataCriacao() {
		assertEquals( 0, conta.getDataCriacao());
	}
	
	@Test
	public void testGetType() {
		assertTrue( conta.getType() == "Investimento" );
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroESaldoNaCriacao() {
		Investimento conta = new Investimento(1000, 500);
		
		assertTrue( conta.getAccountNumber() == 1000 && conta.getBalance() == 500 );
	}
	

}
