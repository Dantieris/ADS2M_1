package com.senac.bank.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senac.bank.account.Investimento;

public class InvestimentoTest {

	@Test
	public void testGerarDividendos() {
		Investimento conta = new Investimento();
		
		conta.depositar(100);
		conta.dividendos(10);
		
		assertEquals( 110, conta.getBalance(), 0);
	}
	
	@Test
	public void testGetDataCriacao() {
		Investimento conta = new Investimento();
		
		assertEquals( 0, conta.getDataCriacao());
	}
	
	@Test
	public void testGetType() {
		Investimento conta = new Investimento();
		
		assertTrue( conta.getType() == "Investimento" );
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroESaldoNaCriacao() {
		Investimento conta = new Investimento(1000, 500);
		
		assertTrue( conta.getAccountNumber() == 1000 && conta.getBalance() == 500 );
	}
	

}
