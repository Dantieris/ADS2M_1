package com.senac.banco.sistema;

import com.senac.banco.cliente.Cliente;
import com.senac.banco.conta.Conta;
import com.senac.console.Console;

public class Gerenciador 
{
	private Cliente cliente;
	private Conta conta;
	private Console console;
	
	public Gerenciador()
	{
		console = new Console();
		
		conta   = new Conta( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
				, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
				, console.recebeNumeroDouble( "Digite o saldo da conta:  " ) );
		
		cliente = new Cliente( console.recebeNome() 
				, console.recebeEndereco() 
				, console.recebeTelefones() 
				, conta);
				
	}
	
	public void realizaSaque()
	{
		
	}
}
