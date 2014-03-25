package com.senac.banco.sistema;

import com.senac.banco.cliente.Cliente;
import com.senac.banco.conta.Conta;
import com.senac.banco.conta.Especial;
import com.senac.banco.conta.Investimento;
import com.senac.console.Console;
import com.senac.util.Data;

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
		cliente = new Cliente( console.recebeNome() 
				, console.recebeEndereco() 
				, testaTelefones( console.recebeTelefones() ) 
				, cadastrarConta() );
	}
	
	//cadastra uma conta no sistema,
	//com configurações diferentes para cada tipo de conta.
	public Conta cadastrarConta()
	{
		Conta conta = null;
		Data data 	= new Data();
		String tipo = testaTipoConta();
		
		if ( tipo.equalsIgnoreCase( "comum" ) )
		{
			conta = new Conta ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.recebeNumeroDouble( "Digite o saldo da conta:  " ) );
		}
		
		if ( tipo.equalsIgnoreCase( "especial" ) )
		{
			conta = new Especial ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.recebeNumeroDouble( "Digite o saldo da conta:  " ) 
					, console.recebeNumeroDouble( "Digite o limite da conta: " ) );
		}
		
		if ( tipo.equalsIgnoreCase( "investimento" ) )
		{
			conta = new Investimento ( console.recebeNumeroInteiro( "Digite o número da conta: " ) 
					, console.recebeNumeroInteiro( "Digite o número de confirmação: " ) 
					, console.recebeNumeroDouble( "Digite o saldo da conta:  " ) 
					, data.recebeDataCompacta()
					, 0.43 );
		}
		
		return conta;
		
	}
	
	//testa se o tipo de conta existe
	//retorna se o tipo for comum, especial ou investimento.
	private String testaTipoConta()
	{		
		String tipo;
		
		do 
		{
			tipo = console.recebeTipoConta();
			System.out.println(tipo);
		}
		while ( !tipo.equalsIgnoreCase( "comum" ) 
				|| !tipo.equalsIgnoreCase( "especial" ) 
				|| !tipo.equalsIgnoreCase( "investimento" ) );
		
		return tipo;
	}
	
	//Testar os valores do tamanho total de String, 
	//em cada índice do vetor.
	private String[] testaTelefones(String[] telefones)
	{
		for ( int i = 0 ; i < telefones.length ; i++)
		{
			switch ( telefones[i].length() )
			
			{
			
			case 0 : telefones[i] = "SemNúmero"; 
			break;
			
			case 7 : telefones[i] = formatarTelefone(telefones[i]); 
			break;
			
			case 9 : telefones[i] = formatarTelefoneOperadora(telefones[i]); 
			break;
			
				default:
				{
					switch (i)
					{
					
					case 1 : telefones[i] = console.recebeTelefone( "celular novamente: " ); 
					break;
					
					case 2 : telefones[i] = console.recebeTelefone( "residencial novamente: " ); 
					break;
					
					case 3 : telefones[i] = console.recebeTelefone( "comercial novamente: " ); 
					break;
					
					}
				}		
			}
		}
		
		return telefones;
	}
	
	//Formata uma string telefone de 7 dígitos
	// em (00)XXX-XXXX.
	private String formatarTelefone(String telefone)
	{
		String prefixo = (String) telefone.subSequence(0, 4);
		String sufixo  = (String) telefone.subSequence(4, telefone.length());
		
		String telefoneFormatado = "(00)" + prefixo + "-" + sufixo;
		
		return telefoneFormatado;
	}
	
	//Formata uma string telefone de 9 dígitos
	// em (XX)XXX-XXXX.
	private String formatarTelefoneOperadora(String telefone)
	{
		String operadora = (String) telefone.subSequence(0, 2);
		String prefixo   = (String) telefone.subSequence(2, 5);
		String sufixo    = (String) telefone.subSequence(5, telefone.length());
		
		String telefoneFormatado = "(" + operadora + ")" + prefixo + "-" + sufixo;
		
		return telefoneFormatado;
	}
	
}
