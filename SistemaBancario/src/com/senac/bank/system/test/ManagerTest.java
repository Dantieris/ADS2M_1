package com.senac.bank.system.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.senac.bank.account.Conta;
import com.senac.bank.account.Especial;
import com.senac.bank.account.Investimento;
import com.senac.bank.system.Manager;

public class ManagerTest {

	private Manager gerenciador;
	
	@Before
	public void setUp() throws Exception {
		gerenciador = new Manager();
	}

	@After
	public void tearDown() throws Exception {
		gerenciador = null;
	}
	
	@Test
	public void testMenuOperationsOperacaoCadastrarClienteComNomeNaoNuloEContaComun() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"common\"." );
		
		gerenciador.menuOperations();
		
		assertEquals( "nome" , gerenciador.getClient().getName() );
	}
	
	@Test
	public void testMenuOperationsOperacaoCadastrarClienteFalharAoCadastrarClienteComNomeNuloEContaComun() {
		System.out.println( "\nOpcao 1. \nCome: nulo. \nConta: \"common\"." );
		
		gerenciador.menuOperations();
		
		assertFalse( gerenciador.getClient().getName().equals(null) );
	}
	
	@Test
	public void testMenuOperationsOperacaoCadastrarClienteComNomeNaoNuloEContaInvestimento() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta \"investment\"." );
		
		gerenciador.menuOperations();
		
		assertTrue( gerenciador.getClient().getAccount() instanceof Investimento );
	}
	
	@Test
	public void testMenuOperationsOperacaoCadastrarClienteComNomeNaoNuloEContaEspecial() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"especial\". \nLimite: 0." );
		
		gerenciador.menuOperations();
		
		assertTrue( gerenciador.getClient().getAccount() instanceof Especial );
	}
	
	@Test
	public void testMenuOperationsOperacaoCadastrarClienteComNomeNaoNuloEContaDiferenteDeCommonEspecialInvestimentoCriandoContaCommon() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"diferente\".");
		
		gerenciador.menuOperations();
		
		assertTrue( gerenciador.getClient().getAccount() instanceof Conta );
	}

	@Test
	public void testMenuOperationsOperacaoDepositarValorPositivoEmContaComun() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"common\"." );
		gerenciador.menuOperations();
		
		System.out.println( "\nOpcao 2. \nDepositar: 100." );
		gerenciador.menuOperations();
		
		assertEquals( 100 , gerenciador.getClient().getAccount().getBalance(), 0 );
	}
	
	@Test
	public void testMenuOperationsOperacaoSacarValorPositivoEmContaComun() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"common\"." );
		gerenciador.menuOperations();
		
		System.out.println( "\nOpcao 2. \nDepositar: 100." );
		gerenciador.menuOperations();
		
		System.out.println( "\nOpcao 3. \nSacar: 50. " );
		gerenciador.menuOperations();
		
		assertEquals( 50,  gerenciador.getClient().getAccount().getBalance(), 0);
	}
	
	@Test
	public void testMenuOperationsOperacaoSacarFalharAoSacarValorNegativoEmContaComun() {
		System.out.println( "\nOpcao 1. \nNome: \"nome\". \nConta: \"common\"." );
		gerenciador.menuOperations();
		
		System.out.println( "\nOpcao 2. \nDepositar: 100." );
		gerenciador.menuOperations();
		
		System.out.println( "\nOpcao 3. \nSacar: -100. " );
		gerenciador.menuOperations();
		
		assertFalse( gerenciador.getClient().getAccount().getBalance() != 100 );
	}
	
	
}