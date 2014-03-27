package com.senac.banco.system;

import com.senac.banco.account.Conta;
import com.senac.banco.account.Especial;
import com.senac.banco.account.Investimento;
import com.senac.banco.members.Cliente;
import com.senac.console.Console;

public class Gerenciador 
{
	private Cliente cliente;
	private Console console;
	
	public Gerenciador()
	{
		console = new Console();
	}
	
	public Cliente getCliente()
	{
		return this.cliente;
	}

	//cadastra um cliente no banco.
	public void cadastrarCliente()
	{
		cliente = new Cliente( console.inputName()  
				, cadastrarConta() );
	}
	
	//cadastra uma conta no sistema,
	//com configurações diferentes para cada tipo de conta.
	public Conta cadastrarConta()
	{
		Conta conta = null;
		String tipo = testaTipoConta();
		
		if ( tipo.equalsIgnoreCase( "comum" ) )
		{
			conta = new Conta ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.inputBalance() );
		}
		
		if ( tipo.equalsIgnoreCase( "especial" ) )
		{
			conta = new Especial ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.inputBalance()
					, console.inputLimit() );
		}
		
		if ( tipo.equalsIgnoreCase( "investimento" ) )
		{
			conta = new Investimento ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.inputBalance() 
					, 0
					, 0.43 );
		}
		
		return conta;
		
	}
	
	//testa se o tipo de conta existe
	//retorna se o tipo for comum, especial ou investimento.
	private String testaTipoConta()
	{		
		String tipo;
		boolean teste = false;
		
		do 
		{
			tipo = console.recebeTipoConta();
			
			if ( tipo.equalsIgnoreCase( "comum" ) 
					|| tipo.equalsIgnoreCase( "especial" ) 
					|| tipo.equalsIgnoreCase( "investimento" ) )
			{
				teste = true;
			}
			else
				teste = false;
		}
		while ( !teste );
		
		return tipo;
	}
	
}
