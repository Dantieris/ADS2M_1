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
			int op = consoleView.inputAccountNumber();
			
			switch ( op ) 
			{
			case 1 : account = new Manager().registeringCommonAccount();
			case 2 : account = new Manager().registeringInvestmentAccount();
			case 3 : account = new Manager().registeringEspecialAccount();
			default: account = new Manager().registeringCommonAccount();
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
	 * 
	 */
	public void startSystem()
	{
		if ( !new File( "BankRegisters.txt").exists() )
			recordBankRegisterForEachContact();
		else
		{	
			while( contacts.hasNext() )
			{
				Manager manager = new Manager();
				Conta account = null;
				String[] register = getRegisterFromFile();
				
				manager.registeringAccount();
				account.depositar( Double.valueOf(register[2]) );
				
				consoleView.printMenu();
				if ( register[1].equalsIgnoreCase( "Investimento" ) )
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
						System.out.println( account.getBalance() );
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
				String acc		= account.getAccountNumber()+ ":" +register[1]+":" +account.getBalance();
				
				// Salva o arquivo.
				registers.close();
								
			}
			
		}
	}
	
	// Adiciona um log ao historico do arquivo.
	public void addLog( String contact, String account) throws FileNotFoundException
	{
		String history = "";
		while( contacts.hasNext() )
		{
			history += contacts.nextLine()+ "\n";
		}
		
		System.out.println(history);
		registers.format("%s", history);
		
		addBankRegister(contact, account);
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
		String[] register = contacts.nextLine().split( ":" );
		
		for (int i = 0 ; i < register.length ; i++)
			System.out.println(register[i]);
		
		return register;
	}
	
	// Switch que define qual conta sera criada, de acordo com o tipo.
	public Conta registredAccount( String number, String type, String balance )
	{
		Conta account = null;
		
		if ( type.equalsIgnoreCase( "common" ) || type.equalsIgnoreCase( "comum" ) )
		{
			account = new Conta();
		}
		
		if ( type.equalsIgnoreCase( "especial" ) )
		{
			account = new Especial( consoleView.inputLimit() );
		}
		
		if ( type.equalsIgnoreCase( "investiment" ) || type.equalsIgnoreCase( "investimento" ) )
	{
			account = new Investimento();
		}
		
		return account;
	}
	 /**
	  * Fecha os arquivos, salvando informações inseridas.
	  */
	public void saveFiles() {
		contacts.close();
		registers.close();
	}
}
