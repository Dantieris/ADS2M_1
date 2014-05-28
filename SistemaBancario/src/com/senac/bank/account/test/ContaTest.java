/**
 * 
 */
package com.senac.bank.account.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.bank.account.Conta;
import com.senac.bank.exceptions.SaldoInsuficienteException;

/**
 * @author Danti
 *
 */
public class ContaTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDepositarValorPositivoEGetBalance() {
		Conta conta = new Conta();
		
		conta.depositar(10);
		
		assertEquals( 10, conta.getBalance(), 0 );	
	}
	
	@Test
	public void testFalharDepositoDeValorNegativo() {
		Conta conta = new Conta();
		
		conta.depositar(-10);
		
		assertFalse( conta.getBalance() == -10 );
	}

	@Test( expected = SaldoInsuficienteException.class )
	public void testSacarValorMaiorQueSaldoDisponivelGeraExecao() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		
		conta.sacar(10);
	}
	
	@Test
	public void testSacarValorPositivo() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		
		conta.depositar(1000);
		conta.sacar(500);
		
		assertEquals( 500, conta.getBalance(), 0 );
	}
	
	@Test( expected = SaldoInsuficienteException.class )
	public void testSacarValorNegativoGeraExcecao() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		
		conta.sacar(-10);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testNumeroDaTerceiraContaCriadaAposUltimaConta() {
		Conta ultima 	= new Conta();
		Conta primeira 	= new Conta();
		Conta segunda 	= new Conta();
		Conta terceira 	= new Conta();
		
		assertEquals( (ultima.getAccountNumber() + 3), terceira.getAccountNumber() );
	}
	
	@Test
	public void testNumeroDeVerificacaoDaConta() {
		Conta conta = new Conta();
		
		assertEquals( (conta.getAccountNumber() % 100), conta.getVerificationNumber() );
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroNaCriacao() {
		Conta conta = new Conta(1000, 0);
		
		assertEquals( 1000 , conta.getAccountNumber());
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroNaCriacaoFalharComNumeroNegativo() {
		Conta conta = new Conta(-1000, 0);
		
		assertFalse( conta.getAccountNumber() == -1000 );
	}
	
	@Test
	public void testGetTypeRetornaTipoDaConta() {
		Conta conta = new Conta();
		
		assertTrue( conta.getType() == "Comum" );
	}
	
	@Test
	public void testConstruirContaDefinindoNumeroSaldoNaCriacao() {
		Conta conta = new Conta(1000, 500);
		
		assertTrue( conta.getAccountNumber() == 1000 && conta.getBalance() == 500 );
	}
}
