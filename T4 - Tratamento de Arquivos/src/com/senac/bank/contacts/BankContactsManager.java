package com.senac.bank.contacts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import com.senac.PraticaOOP.Controler;
import com.senac.bank.console.Console;
import com.senac.util.Pessoa;

public class BankContactsManager {
	
	private Controler contactsController;
	private Formatter contacts;
	private Console printer;

	public BankContactsManager()
	{
		contactsController 	= new Controler();
		printer				= new Console();
	}
	
	// cria um arquivo Contacts.txt.
	public void createFile()
	{
		new File( "Contacts.txt" );
	}
	
	// abre o arquivo Contacts.txt no Formatter contacts.
	public void openFile() throws FileNotFoundException, IOException
	{
		contacts = new Formatter( new BufferedWriter ( new FileWriter( "Contacts.txt" ) ) );
	
	}
	
	
	// fecha o arquivo Contacts.txt, salvando o texto.
	public void saveFile()
	{
		contacts.close();
	}
	
	// adiciona um contato ao arquivo Contacts.txt.
	public void addContact( Pessoa contact ) throws FormatterClosedException
	{
		contacts.format( "%s;%s;%s", contact.getNome(), 
				contact.getEndereco(),
				contact.getTelefone()[0] );
	}
	
	public void record20Contacts()
	{
		Pessoa contact = null;
		
		// Criando o arquivo.
		createFile();
		
		// Abrindo o arquivo.
		try 
		{
			openFile();
		} 
		catch (FileNotFoundException e) 
		{
			printer.printError( "Error file not found." );
		} 
		catch (IOException e) 
		{
			printer.printError( "Error opening file failed." );
		}
		
		// Criando 20 contatos e armazenando no arquivo.
		for ( int i = 0 ; i < 20 ; i++ )
		{
			contact = contactsController.gerarContatoAleatorio();
			addContact(contact);
		}
		
		// Fechando o arquivo.
		saveFile();
		
		// Imprime mensagem de operação concluida.
		printer.printLine( "Operation completed." );
	}
	
}
