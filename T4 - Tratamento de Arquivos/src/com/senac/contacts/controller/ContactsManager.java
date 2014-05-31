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

/**
 * Esta classe representa um gerenciador de contatos,
 *  gerar contatos aleatórios e gravar em um arquivo.txt.
 *
 */
public class ContactsManager {
	
	private Controler contactsController;
	private Formatter writer;
	private BankConsole printer;

	/**
	 * Inicialia um objeto ContactsManager recém-criado.
	 * 
	 * @throws IOException Se houver problema de input ou output.
	 * @throws FileNotFoundException Se o arquivo não for encontrado.
	 */
	public ContactsManager() throws IOException, FileNotFoundException
	{
		contactsController 	= new Controler();
		printer				= new BankConsole();
		writer = new Formatter( new BufferedWriter ( new FileWriter( "Contacts.txt" ) ) );
	}
	
	/**
	 * Salva as informações contidas no arquivo.
	 * 
	 * @param arquivo O arquivo a ser salvo. 
	 */
	public void saveFile( Formatter arquivo )
	{
		arquivo.close();
	}

	/**
	 * Armazena um contato no arquivo de contatos.
	 * 
	 * @param contact O contato a ser armazenado.
	 * @throws FormatterClosedException Se o arquivo estiver fechado.
	 */
	public void addContact( Pessoa contact ) throws FormatterClosedException
	{
		writer.format( "%s:%s:%s%n", contact.getNome(), 
				contact.getEndereco(),
				contact.getTelefone()[0] );
	}
	
	/**
	 * Gera vinte contatos aleatórios e os armazena num arquivo.
	 */
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
