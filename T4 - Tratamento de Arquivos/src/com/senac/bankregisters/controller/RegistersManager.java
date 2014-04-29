package com.senac.bankregisters.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

import com.senac.bank.account.Conta;
import com.senac.bank.account.Especial;
import com.senac.bank.account.Investimento;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bankregisters.view.BankView;

public class RegistersManager {

	private BankView consoleView;
	private Scanner contacts; // Arquivo Contacts.txt.
	private Scanner registers; // Arquivo BankRegisters.txt para leitura.
	private Formatter bankRegister; // Arquivo BankRegisters.txt.
	
	public RegistersManager()
	{
		consoleView = new BankView();
	}
	
	// Abre o arquivo BankRegisters.txt para leitura.
	public void opneBankRegistersToRead() throws FileNotFoundException, IOException
	{
		registers = new Scanner ( new BufferedReader( new FileReader( "BankRegisters.txt" ) ) );
	}
	
	// Abre um arquivo BankRegisters.txt para escrever, caso nao exista um, será criado.
	public void openFileBankRegister() throws FileNotFoundException, IOException
	{
		bankRegister = new Formatter( new BufferedWriter ( new FileWriter( "BankRegisters.txt" ) ) );
	}
	
	// Abre o arquivo Contacts.txt.
	public void openContacts() throws FileNotFoundException
	{
		contacts = new Scanner ( new BufferedReader( new FileReader( "Contacts.txt" ) ) );
	}
	
	// Fecha o arquivo BankRegisters.txt.
	public void saveFileBankRegister()
	{
		bankRegister.close();
	}
	
	// Armazena um registro bancário ao arquivo BankRegisters.txt.
	public void addBankRegister( String contact, String account ) throws FileNotFoundException
	{
		bankRegister.format( "%s:%s%n" , account
										, contact);
	}
	
	// Recebe um contato do arquivo Contacts.txt.
	public String getContactRegisterFromContacts()
	{
		return contacts.nextLine();
	}
	
	// Armazena uma conta para cada contato.
	public void recordBankRegisterForEachContact()
	{
			String contact = null;
			String account = null;
			
			// Abrindo arquivos para leitur e escrita.
			
			// Contacts arquivo.
			try 
			{
				openContacts();
			} 
			catch (FileNotFoundException e1) 
			{
				consoleView.printError( "Error Contacts.txt file not found." );
			}
			
			// Bank Registers arquivo.
			try 
			{
				openFileBankRegister();
			} 
			catch (FileNotFoundException e1) 
			{
				consoleView.printError( "Error BankRegisters.txt file not found." );
			} 
			catch (IOException e1) 
			{
				consoleView.printError( "Error opening BankRegisters.txt file failed." );
			}
			
			while( contacts.hasNext() )
			{
				account = consoleView.inputAccountNumber() + ":";
				account += consoleView.inputAccountType() + ":";
				account += consoleView.inputBalance();				
							
				contact = getContactRegisterFromContacts();
				
				try 
				{
					addBankRegister(contact, account);
				} 
				catch (FileNotFoundException e) 
				{
					consoleView.printError( "Error file not found." );
				}
				
				contact = null;
				account = null;
			}
			
			// Fecha BankRegisters.txt.
			saveFileBankRegister();
	}

	public void startSystem()
	{
		if ( !new File( "BankRegisters.txt").exists() )
			recordBankRegisterForEachContact();
		else
		{
			try 
			{
				opneBankRegistersToRead();
			} 
			catch (FileNotFoundException e1) 
			{
				consoleView.printError( "Error BankRegisters.txt file not found." );
			} 
			catch (IOException e1) 
			{
				consoleView.printError( "Error opening BankRegisters.txt file failed." );
			}
			
			Conta account = null;
			String [] register = getRegisterFromFile();
			account = registredAccount( register[0], register[1], register[2] );
			
			consoleView.printMenu();
			if ( register[1].equalsIgnoreCase( "investimento" ) || register[1].equalsIgnoreCase( "investment" ) )
				consoleView.printDividendsOperation();
			
			int op = consoleView.inputInteger();
			
			switch ( op )
			{
			case 1 : account.depositar( consoleView.inputAmountToDeposit() ); break;
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
				} break;
			case 3 : 
				if ( account.getClass().equals( Investimento.class ) )
				{
					Investimento acc = (Investimento) account;
					acc.dividendos( 0.14 );
				} break;
				
			default : consoleView.printError( "Error incorrect operation." );
			
			}
			register[3] = String.valueOf( account.getBalance() );
			
			
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
		String[] register = registers.nextLine().split( ":" );
		
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
			account = registeringCommonAccount( number, balance );
		}
		
		if ( type.equalsIgnoreCase( "especial" ) )
		{
			account = registeringEspecialAccount( number, balance );
		}
		
		if ( type.equalsIgnoreCase( "investiment" ) || type.equalsIgnoreCase( "investimento" ) )
	{
			account = registeringInvestimentAccount( number, balance );
		}
		
		return account;
	}
	
	// Cria uma conta do tipo Comum
	private Conta registeringCommonAccount( String number, String balance )
	{
		return new Conta ( Integer.parseInt( number )
				, number.charAt(0)
				, Double.parseDouble( balance ) );
	}
	
	// Cria uma conta do tipo Investimento
	private Investimento registeringInvestimentAccount( String number, String balance )
	{
		return new Investimento ( Integer.parseInt( number ) 
				, number.charAt(0)
				, Double.parseDouble( balance )
				, 0
				, 0.43 );
	}
	
	// Cria uma conta do tip 
	private Especial registeringEspecialAccount( String number, String balance )
	{
		return new Especial ( Integer.parseInt( number )
				, number.charAt(0) 
				, Double.parseDouble( balance )
				, ( Double.parseDouble( balance ) * 2 ) );
	}
	
}
