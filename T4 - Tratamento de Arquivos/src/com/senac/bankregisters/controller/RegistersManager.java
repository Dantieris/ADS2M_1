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
import com.senac.util.Pessoa;

public class RegistersManager {

	private BankView consoleView;
	private Scanner reader; // Arquivo BankRegisters.txt para leitura.
	private Formatter writer; // Arquivo BankRegisters.txt.
	
	// Construtor
	public RegistersManager()
	{
		consoleView = new BankView();
	}
	
	// Abre um arquivo para leitura, parametro caminho ou nome do arquivo.
	public void openFileToRead( String path ) throws FileNotFoundException, IOException
	{
		reader = new Scanner ( new BufferedReader( new FileReader( path ) ) );
	}
	
	// Abre um arquito para escrita, parametro caminho ou nome do arquivo.
	public void openFileToWrite( String path ) throws FileNotFoundException, IOException
	{
		writer = new Formatter( new BufferedWriter ( new FileWriter( path ) ) );
	}
	
	// Armazena um registro bancário ao arquivo BankRegisters.txt.
	public void addBankRegister( String contact, String account ) throws FileNotFoundException
	{
		writer.format( "%s:%s%n" , account
								 , contact);
	}
	
	// Armazena uma conta para cada contato.
	public void recordBankRegisterForEachContact()
	{
		// Abrindo arquivos para leitur e escrita.
			
		// Contacts arquivo.
		try 
		{
			openFileToRead( "Contacts.txt" );
		} 
		catch (FileNotFoundException fnfe) 
		{
			consoleView.printError( "Error Contacts.txt file not found." );
		} catch (IOException e) 
		{
			consoleView.printError( "Error opening Contacts.txt file failed." );
		}
		
		// Bank Registers arquivo.
		try 
		{
			openFileToWrite( "BankRegisters.txt" );
		} 
		catch (FileNotFoundException fnfe) 
		{
			consoleView.printError( "Error BankRegisters.txt file not found." );
		}
		 
		catch (IOException ioe) 
		{
				consoleView.printError( "Error opening BankRegisters.txt file failed." );
		}
					
		while( reader.hasNext() )
		{
			Conta account;
			String contactRegister = reader.nextLine();
			
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
					consoleView.printError( "Error file not found." );
			}
			
			contactRegister = null;
			account = null;
		}
		
		// Fecha BankRegisters.txt.
		reader.close();
		writer.close();
	}

	public void startSystem()
	{
		if ( !new File( "BankRegisters.txt").exists() )
			recordBankRegisterForEachContact();
		else
		{
			// Abrindo BankRegisters.txt para escrita.
			try 
			{
				openFileToWrite( "BankRegisters.txt" );
			} 
			catch (FileNotFoundException e1) 
			{
				consoleView.printError( "Error BankRegisters.txt file not found." );
			} 
			catch (IOException e1) 
			{
				consoleView.printError( "Error opening BankRegisters.txt file failed." );
			}
			
			while( reader.hasNext() )
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
				
				// Abre o arquivo BankRegisters.txt para armazenar o log.
				try 
				{
					openFileToWrite( "BankRegisters.txt" );
				} 
				catch (FileNotFoundException e1) 
				{
					consoleView.printError( "Error BankRegisters.txt file not found." );
				} 
				catch (IOException e1) 
				{
					consoleView.printError( "Error opening BankRegisters.txt file failed." );
				}
				
				// Adiciona o log ao arquivo
				try 
				{
					addLog(contact, acc);
				} 
				catch (FileNotFoundException e) 
				{
					consoleView.printError( "Error file not found." );
				}
				
				// Salva o arquivo.
				writer.close();
								
			}
			
		}
	}
	
	// Adiciona um log ao historico do arquivo.
	public void addLog( String contact, String account) throws FileNotFoundException
	{
		String history = "";
		while( reader.hasNext() )
		{
			history += reader.nextLine()+ "\n";
		}
		
		System.out.println(history);
		writer.format("%s", history);
		
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
		String[] register = reader.nextLine().split( ":" );
		
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
	
}
