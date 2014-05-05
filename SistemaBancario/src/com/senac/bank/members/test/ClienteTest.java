package com.senac.bank.members.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.senac.bank.account.Conta;
import com.senac.bank.account.Especial;
import com.senac.bank.account.Investimento;
import com.senac.bank.members.Cliente;

public class ClienteTest {

	@Test
	public void testSetNameValorDiferenteDeNuloEGetName() {
		Cliente cliente = new Cliente( "nome", new Conta() );
		
		cliente.setName("DiferenteDeNulo");
		
		assertEquals("DiferenteDeNulo", cliente.getName() );
	}
	
	@Test
	public void testSetAccountContaInvestimentoEGetAccount() {
		Cliente cliente = new Cliente( "nome", new Conta() );
		
		Investimento conta = new Investimento();
		cliente.setAccount( conta );
		
		assertEquals( conta, cliente.getAccount() );
	}
	
	@Test
	public void testSetAccountContaEspecialEGetAccount() {
		Cliente cliente = new Cliente( "nome", new Conta() );
		
		Especial conta = new Especial( 0 );
		cliente.setAccount( conta );
		
		assertEquals( conta, cliente.getAccount() );
	}
}
