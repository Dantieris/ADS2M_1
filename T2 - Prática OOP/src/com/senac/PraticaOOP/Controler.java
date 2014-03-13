package com.senac.PraticaOOP;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Controler 
{
	private View view;
	private String primeiroNome[] = { "João" , "Pedro" , "Maria" , "Claudia" , "José" };
	private String segundoNome[]  = { "Abreu" , "Almeida" , "Alves" , "Barreto" , "Bastos" , "Borges" , "Camargo" , "Coelho" , "Dias" , "Silva"};
	
	public String[] getPrimeiroNome() {
		return primeiroNome;
	}

	public String[] getSegundoNome() {
		return segundoNome;
	}

	public Controler()
	{
		view = new View();
		
	}
	
	//criando um objeto contato.
	//retorno Pessoa contato devolve um contato com nome, endereço e telefones.
	public Pessoa criarContato()
	{
		Pessoa contato = new Pessoa( view.recebeNome(), view.recebeEndereco(), testaTelefones(view.recebeTelefones()) );
		
		return contato;
	}
	
	//Imprime na tela um contato
	//parâmetro Pessoa contato é o objeto que será mostrado na tela.
	public void listarContato(Pessoa contato)
	{
		view.imprimeContato(contato.getNome(), contato.getEndereco(), contato.getTelefone());
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
		
		System.out.println(telefoneFormatado);
		
		return telefoneFormatado;
	}
	
	//gera uma combinação de um item do vetor primeiroNome, 
	//e um item do vetor segundoNome.
	private String gerarNomeAleatorio()
	{
		java.util.Random random = new java.util.Random();
		
		int indiceNome = random.nextInt ( getPrimeiroNome().length );
		int indiceSobrenome = random.nextInt ( getSegundoNome().length );
		
		String nomeAleatorio = getPrimeiroNome()[indiceNome] + " " + getSegundoNome()[indiceSobrenome];
		
		return nomeAleatorio;
	}
	
	//gera um endereço aleatório
	private String gerarEnderecoAleatorio()
	{
		String endereco = "Rua " + gerarNomeAleatorio();
		
		return endereco;
	}
	
	//gera um número aleatório entre 0 e o parâmetro numeroLimite exclusivamente.
	//o número pode chegar até o numeriLimite - 1.
	private int gerarNumeroAleatorio(int numeroLimite)
	{
		java.util.Random random = new java.util.Random();
		
		int numeroAleatorio = random.nextInt( numeroLimite );
		
		return numeroAleatorio;
	}
	
	//gera um telefone aleatóriamente, no formato
	// (XX)XXX-XXXX.
	private String gerarTelefoneAleatorio()
	{
		String telefone = "";
		while(telefone.length() != 12)
		{
			telefone = "(" + ( gerarNumeroAleatorio(50) + 1 ) + ")" + "555-" + gerarNumeroAleatorio(9999);
		}
		return telefone;
	}
	
	//gera um vetor com 3 telefones, no formato
	// (XX)XXX-XXXX.
	private String[] gerarTelefones()
	{
		String telefones[] = new String[3];
		for ( int i = 0 ; i < telefones.length ; i++)
			telefones[i] = gerarTelefoneAleatorio();
		return telefones;
	}
	
	//Testar os valores do tamanho total de String, 
	//em cada índice do vetor.
	private String[] testaTelefones(String[] telefones)
	{
		for ( int i = 0 ; i < telefones.length ; i++)
		{
			switch (telefones[i].length())
			{
			case 0 : telefones[i] = "SemNúmero"; break;
			case 7 : telefones[i] = formatarTelefone(telefones[i]); break;
			case 9 : telefones[i] = formatarTelefoneOperadora(telefones[i]); break;
				default:
				{
					switch (i)
					{
					case 1 : telefones[i] = view.recebeTelefone( "celular novamente: " ); break;
					case 2 : telefones[i] = view.recebeTelefone( "residencial novamente: " ); break;
					case 3 : telefones[i] = view.recebeTelefone( "comercial novamente: " ); break;
					}
				}		
			}
		}
		
		for (int i = 0 ; i < 3 ; i++)
			System.out.println("telefones " + telefones[i] + "indice " + i);
		
		return telefones;
	}
	
	//gerar um contato aleatório
	//retorna este contato.
	public Pessoa gerarContatoAleatorio()
	{
		Pessoa contato = new Pessoa(gerarNomeAleatorio(), gerarEnderecoAleatorio(), gerarTelefones());
		return contato;
	}
	
}

