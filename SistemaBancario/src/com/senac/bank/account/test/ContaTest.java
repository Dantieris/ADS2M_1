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
	
}
