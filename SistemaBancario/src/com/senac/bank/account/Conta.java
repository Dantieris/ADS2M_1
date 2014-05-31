package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

/**
 * Esta classe representa uma conta banc�ria comum, cont�m: 
 * n�mero da conta, n�mero de verifica��o, e saldo.
 *
 */
public class Conta 
{
	protected double saldo;
	private int numConta;
	private int numVerificacao;
	private static int proximaConta = 10000;
	
	/**
	 * Inicializa um objeto Conta rec�m-criado com saldo 0, n�mero de conta e verifica��o gerados automaticamente.
	 */
	public Conta( )
	{
		this.numConta 		= proximaConta;
		proximaConta++;
		this.numVerificacao = this.numConta % 100;
		this.saldo 			= 0;
	}
	
	/**
	 * Inicializa um objeto Conta rec�m-criado com saldo definido pelo parametro, e n�mero de conta tamb�m, 
	 * o n�mero de verifica��o � gerado automaticamente.
	 * 
	 * @param numConta N�mero da conta.
	 * @param saldo Saldo inicial da conta.
	 */
	public Conta(int numConta, double saldo) {
		if (numConta > 0)
			this.numConta = numConta;
		else {
			this.numConta = proximaConta;
			proximaConta++;
		}
		
		this.numVerificacao = this.numConta % 100;
		this.saldo			= saldo;
	}

	/**
	 * Informa o valor do saldo atual da conta.
	 * 
	 * @return O valor atual do saldo.
	 */
	public double getBalance() 
	{
		return saldo;
	}

	/**
	 * Define o valor do saldo pelo parametro balance.
	 * 
	 * @param balance O valor a ser definido do saldo.
	 */
	protected void setBalance( double balance ) 
	{
		this.saldo = balance;
	}

	/**
	 * Informa o n�mero da conta.
	 * 
	 * @return O n�mero da conta.
	 */
	public int getAccountNumber() 
	{
		return numConta;
	}

	/**
	 * Informa o n�mero de verifica��o da conta.
	 * 
	 * @return O n�mero de verifica��o.
	 */
	public int getVerificationNumber() 
	{
		return numVerificacao;
	}
	
	/**
	 * Deposita um valor no saldo da conta.
	 * 
	 * @param value Valor do dep�sito.
	 */
	public void depositar( double value )
	{
		if ( value > 0 )
			saldo += value;
	}
	
	/**
	 * Retira um valor do saldo da conta.
	 * 
	 * @param value Valor a sacar.
	 * @throws SaldoInsuficienteException Se o saldo for menor do que o valor, ou o valor for negativo.
	 */
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( getBalance() < value || value < 0 )
			throw new SaldoInsuficienteException();
		
		saldo -= value;
	}
	
	/**
	 * Informa o tipo de conta.
	 * 
	 * @return O tipo desta conta.
	 */
	public String getType() {
		return "Comum";
	}
}
