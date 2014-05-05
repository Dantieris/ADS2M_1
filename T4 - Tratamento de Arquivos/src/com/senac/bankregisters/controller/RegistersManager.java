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
import com.senac.bankregisters.view.BankView;

public class RegistersManager {

	private BankView consoleView;
	private Scanner contacts; // Arquivo Contacts.txt.
	private Scanner registers; // Arquivo BankRegisters.txt para leitura.
	private Formatter bankRegister; // Arquivo BankRegisters.txt.
	private String[] register;
	
	public String[] getRegister() {
		return register;
	}

	public void setRegister(String[] register) {
		this.register = register;
	}

	public RegistersManager()
	{
		consoleView = new BankView();
	}
	
	// Abre o arquivo BankRegisters.txt para leitura.
	public void openBankRegistersToRead() throws FileNotFoundException, IOException
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
			// Abrindo BankRegisters.txt para escrita.
			try 
			{
				openBankRegistersToRead();
			} 
			catch (FileNotFoundException e1) 
			{
				consoleView.printError( "Error BankRegisters.txt file not found." );
			} 
			catch (IOException e1) 
			{
				consoleView.printError( "Error opening BankRegisters.txt file failed." );
			}
			
			while( registers.hasNext() )
			{
				Conta account = null;
				register = getRegisterFromFile();
				account = registredAccount( register[0], register[1], register[2] );
				
				consoleView.printMenu();
				if ( register[1].equalsIgnoreCase( "investimento" ) || register[1].equalsIgnoreCase( "investment" ) )
					consoleView.printDividendsOperation();
				
				int op = consoleView.inputInteger();
				
				switch ( op )
				{
				case 1 : 
					account.depositar( consoleView.inputAmountToDeposit() ); break;
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
				
				String contact 	= register[3]+ ":" +register[4]+ ":" +register[5];
				String acc		= account.getAccountNumber()+ ":" +register[1]+":" +account.getBalance();
				
				// Abre o arquivo para armazenar o log.
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
				saveFileBankRegister();
				
			}
			
		}
	}
	
	// Adiciona um log ao historico do arquivo.
	public void addLog( String contact, String account) throws FileNotFoundException
	{
		String history = "";
		while( registers.hasNext() )
		{
			history += registers.nextLine()+ "\n";
		}
		
		System.out.println(history);
		bankRegister.format("%s", history);
		
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
