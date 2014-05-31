package com.senac.bank.system;

import com.senac.bank.account.Conta;
import com.senac.bank.account.Especial;
import com.senac.bank.account.Investimento;
import com.senac.bank.console.BankConsole;
import com.senac.bank.exceptions.NoClientFoundException;
import com.senac.bank.exceptions.SaldoInsuficienteException;
import com.senac.bank.members.Cliente;

/**
 * 
 * Esta classe representa um gerenciador de contas/clientes bancários. Realiza as operações: 
 * saque, deposito, dividendos, cadastro de contas/clientes.
 * 
 */
public class Manager
{
	private Cliente client;
	private Conta account;
	private BankConsole console;
	
	/**
	 * Inicializa um objeto Manager recém-criado.
	 */
	public Manager()
	{
		console = new BankConsole();
	}
	
	/**
	 * Informa o cliente atual do gerenciador.
	 * 
	 * @return O cliente.
	 */
	public Cliente getClient()
	{
		return this.client;
	}

	/**
	 * Cadastra um cliente novo no sistema.
	 */
	public void registeringClient()
	{
		client = new Cliente( console.inputName() , account );
	}
	
	/**
	 * Recebe um tipo de conta e realiza o seu cadastro.
	 */
	public void registeringAccount()
	{
		int op = console.inputInteger();
		
		switch ( op )
		{
		case 1 : account = registeringCommonAccount(); break;
		case 2 : account = registeringInvestmentAccount(); break;
		case 3 : account = registeringEspecialAccount(); break;
		default: account = registeringCommonAccount();
		}

	}
	
	/**
	 * Cria um conta comum.
	 * 
	 * @return A conta criada.
	 */
	public Conta registeringCommonAccount() {
		return new Conta();
	}
	
	/**
	 * Cria uma conta de investimentos.
	 * 
	 * @return A conta criada.
	 */
	public Conta registeringInvestmentAccount() {
		return new Investimento();
	}
	
	/**
	 * Cria uma conta especial.
	 * 
	 * @return A conta criada.
	 */
	public Conta registeringEspecialAccount() {
		return new Especial( 1000.0 );
	}
	
	/**
	 * Apresenta o menu de operações para o usuário, 
	 * e de acordo com a escolha é feita a operação.
	 */
	public void menuOperations()
	{
			console.printMenuOperations();
			
			int operations = console.inputInteger();
			
			switch ( operations )
			{
			//operation register client.
			case 1 : 
				{
					if ( getClient() == null )
						registeringClient();
					else
					{
						console.printError("There is one client registered.");
					}
				}
					break;
			//operation deposit.
			case 2 : 
				{
					try
					{
						if ( getClient() == null )		
							throw new NoClientFoundException();
						
						client.getAccount().depositar( console.inputAmountToDeposit() );
						
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}					
				}
					break;
			//operation withdraw.
			case 3 : 
				{
					try
					{
						if ( getClient() == null )
							throw new NoClientFoundException();
						else
						{
							try
							{
								client.getAccount().sacar( console.inputAmountToWithdrawal() );
							}
							catch ( SaldoInsuficienteException e )
							{
								console.printError( e.getMessage() + ". Available balance " + client.getAccount().getBalance() );
							}	
						}
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}
					
				}
					break;
			//operation print extract.
			case 4  : 
				{
					try
					{
						if ( getClient() == null)
							throw new NoClientFoundException();
						else
						{
							console.printExtract( client.getAccount().getAccountNumber()
									, client.getAccount().getVerificationNumber()
									, client.getAccount().getBalance() );
						}
					}
					catch ( NoClientFoundException ncfe )
					{
						console.printError( ncfe.getMessage() );
					}
				}
					break;
			//operation close the application.
			case 5  : System.exit(0);
					break;
			
			default : console.printError( "Unknown Operation." );
					break;
			}
	}
	
}
