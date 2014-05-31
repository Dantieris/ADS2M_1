package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

/**
 * Esta classe representa uma conta bancária comum, contém: 
 * número da conta, número de verificação, e saldo.
 *
 */
public class Conta 
{
	protected double saldo;
	private int numConta;
	private int numVerificacao;
	private static int proximaConta = 10000;
	
	/**
	 * Inicializa um objeto Conta recém-criado com saldo 0, número de conta e verificação gerados automaticamente.
	 */
	public Conta( )
	{
		this.numConta 		= proximaConta;
		proximaConta++;
		this.numVerificacao = this.numConta % 100;
		this.saldo 			= 0;
	}
	
	/**
	 * Inicializa um objeto Conta recém-criado com saldo definido pelo parametro, e número de conta também, 
	 * o número de verificação é gerado automaticamente.
	 * 
	 * @param numConta Número da conta.
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
	 * Informa o número da conta.
	 * 
	 * @return O número da conta.
	 */
	public int getAccountNumber() 
	{
		return numConta;
	}

	/**
	 * Informa o número de verificação da conta.
	 * 
	 * @return O número de verificação.
	 */
	public int getVerificationNumber() 
	{
		return numVerificacao;
	}
	
	/**
	 * Deposita um valor no saldo da conta.
	 * 
	 * @param value Valor do depósito.
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
