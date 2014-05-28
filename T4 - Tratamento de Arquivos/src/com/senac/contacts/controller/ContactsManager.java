package com.senac.contacts.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import com.senac.PraticaOOP.Controler;
import com.senac.bank.console.BankConsole;
import com.senac.util.Pessoa;

public class ContactsManager {
	
	private Controler contactsController;
	private Formatter writer;
	private BankConsole printer;

	public ContactsManager() throws IOException, FileNotFoundException
	{
		contactsController 	= new Controler();
		printer				= new BankConsole();
		writer = new Formatter( new BufferedWriter ( new FileWriter( "Contacts.txt" ) ) );
	}
	
	// fecha o arquivo Contacts.txt, salvando o texto.
	public void saveFile( Formatter ft )
	{
		ft.close();
	}
	
	// adiciona um contato ao arquivo Contacts.txt.
	public void addContact( Pessoa contact ) throws FormatterClosedException
	{
		writer.format( "%s:%s:%s%n", contact.getNome(), 
				contact.getEndereco(),
				contact.getTelefone()[0] );
	}
	
	public void record20Contacts()
	{
		Pessoa contact = null;
		
		// Abrindo o arquivo.

		
		// Criando 20 contatos e armazenando no arquivo.
		for ( int i = 0 ; i < 20 ; i++ )
		{
			contact = contactsController.gerarContatoAleatorio();
			addContact(contact);
		}
		
		// Fechando o arquivo.
		saveFile( writer );
		
		// Imprime mensagem de operação concluida.
		printer.printLine( "Operation completed." );
	}
	
}
