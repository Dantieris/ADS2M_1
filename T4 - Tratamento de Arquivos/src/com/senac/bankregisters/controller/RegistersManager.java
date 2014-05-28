package com.senac.bankregisters.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import com.senac.bank.account.Conta;
import com.senac.bank.account.Especial;
import com.senac.bank.account.Investimento;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bank.system.Manager;
import com.senac.bankregisters.view.BankView;

/**
 * Gerencia registros bancários, adiciona, atualiza, e registra estas informações em arquivos.
 * 
 * @author Danti
 */

public class RegistersManager {

	private BankView consoleView;
	private Scanner contacts; 
	private Scanner bankRegisters;
	private Formatter registers; 
	
	/**
	 * Constroi um gerenciador de registros.
	 * 
	 * @throws (@exception IOException) 
	 * @throws (@exception FileNotFoundException) Arquivo nao encontrado.
	 */
	public RegistersManager() throws IOException, FileNotFoundException
	{
		consoleView = new BankView();
		contacts = new Scanner ( new BufferedReader( new FileReader( "Contacts.txt") ) );
		bankRegisters = new Scanner ( new BufferedReader( new FileReader( "Registers.txt") ) );
		registers = new Formatter( new BufferedWriter ( new FileWriter( "Registers.txt", true ) ) );
	}
	
	/**
	 * Adiciona um registro bancario no arquivo.
	 * 
	 * @param contact Informações sobre o contato a ser inserido.
	 * @param account Informações sobre a conta a ser inserida.
	 * @throws (@exception FileNotFoundException) Arquivo nao encontrado.
	 */
	public void addBankRegister( String contact, String account ) throws FileNotFoundException
	{
		registers.format( "%s:%s%n" , account
								 , contact);
	}
	
	/**
	 * Armazena um registro bancario para cada contato. 
	 * Cria uma conta bancaria para cada contato do arquivo, 
	 * e salva as informações de conta e do contato no arquivo de registro bancario.
	 * 
	 */
	
	public void recordBankRegisterForEachContact()
	{
		while( contacts.hasNext() )
		{
			Conta account;
			String contactRegister = contacts.nextLine();
			
			consoleView.printMenuAccountTypes();
			String op = consoleView.inputAccountType();
			
			switch ( op ) 
			{
			case "1" : account = new Conta(); break;
			case "2" : account = new Investimento(); break;
			case "3" : account = new Especial(1000); break;
			default: account = new Conta();
			}
			
			try 
			{
				String accRegister = account.getAccountNumber() + ":" + account.getType() + ":" + account.getBalance();
				addBankRegister( contactRegister, accRegister );
			}
			catch (FileNotFoundException e) 
			{
					consoleView.printError( "File not found." );
			}
			
			contactRegister = null;
			account = null;
		}
		
	}
	
	/**
	 * Carrega dados dos registros bancarios, realiza operacoes de saque e dividendos, e armazena atualizacoes ao arquivo.
	 * 
	 * @throws (@exception FileNotFoundException) Arquivo nao encontrado. 
	 */
	public void updateBankRegisters() throws FileNotFoundException
	{
		while( bankRegisters.hasNext() )
		{
			Conta account = new Conta();
			String[] register = getRegisterFromFile();
			String type = register[1];
			
			switch ( type ) {
			case "Comum" : account = new Conta( Integer.parseInt(register[0]), Double.parseDouble(register[2]) ); break;
			case "Investimento" : account = new Investimento( Integer.parseInt(register[0]), Double.parseDouble(register[2]) ); break;
			case "Especial" : account = new Especial(Integer.parseInt(register[0]), Double.parseDouble(register[2]), 1000); break;
			}
			
			consoleView.printMenu();
			if ( type.equalsIgnoreCase( "Investimento" ) )
				consoleView.printDividendsOperation();
			
			int op = consoleView.inputInteger();
			
			// 1 - Depositar
			// 2 - Sacar
			// 3 - Gerar Dividendos
			switch ( op )
			{
			case 1 : 
				account.depositar( consoleView.inputAmountToDeposit() );
				break;
				
			case 2 : 
				try 
				{
					account.sacar( consoleView.inputAmountToWithdrawal() );
				} 
				catch (SaldoInsuficienteException e) 
				{
					if ( account.getClass().equals( Especial.class ) )
						consoleView.printError( e.getMessage() + " Available amount: " + ((Especial) account).getLimite() );
					else
						consoleView.printError( e.getMessage() + " Available amount: " + account.getBalance() );
					} 
				break;
				
			case 3 : 
				if ( account.getClass().equals( Investimento.class ) )
				{
					Investimento acc = (Investimento) account;
					acc.dividendos( 0.43 );
				} 
				break;
				
			default : consoleView.printError( "Error incorrect operation." );
			}
			
			String contact 	= register[3]+ ":" +register[4]+ ":" +register[5];
			String acc		= account.getAccountNumber()+ ":" +type+ ":" +account.getBalance();
			
			addBankRegister(contact, acc);
		}
		
	}
	
	// Separa em um vetor os valores de uma linha de registro
	// indice 0 contem o numero da conta
	// indice 1 contem o tipo da conta
	// indice 2 contem o saldo da conta
	// indice 3 contem o nome do cliente
	// indice 4 contem o endereco do cliente
	// indice 5 contem o telefone do cliente.
	public String[] getRegisterFromFile()
	{ 
		return bankRegisters.nextLine().split( ":" );
	}

	 /**
	  * Fecha os arquivos, salvando informações inseridas.
	  */
	public void saveFiles() {
		registers.close();
	}
	
	/**
	 * Informa se o arquivo com registros esta vazio.
	 * 
	 * @return Retorna verdadeiro se o arquivo com os registros possui informacao, caso contrario retorna falso.
	 */
	public boolean isRegistersEmpty() {
		return bankRegisters.hasNext();
	}
}
