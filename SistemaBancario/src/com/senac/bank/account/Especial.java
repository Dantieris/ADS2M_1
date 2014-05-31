package com.senac.bank.account;

import com.senac.bank.exceptions.SaldoInsuficienteException;

/**
 * Esta classe representa uma conta bancária Especial, contém: 
 * número da conta, número de verificação, saldo, e limite de saque.
 *
 */
public class Especial extends Conta 
{
	private double limite;
	
	/**
	 * Inicializa um objeto Especial recém-criado com saldo 0, 
	 * número de conta e verificação automaticamente, 
	 * e limite de saque definido por parametro.
	 * @param limite
	 */
	public Especial( double limite ) 
	{
		super();
		this.limite = limite;
		
		if (limite < 0)
			this.limite = 1000.0;
	}

	/**
	 * Inicializa um objeto Especial recém-criado com saldo definido pelo parametro, 
	 * número de conta e limite de saque também, 
	 * já o número de verificação é gerado automaticamente.
	 * 
	 * @param numConta Número da conta.
	 * @param saldo Saldo inicial da conta.
	 * @param limite Limite de saque.
	 */
	public Especial(int numConta, double saldo, double limite) {
		super(numConta, saldo);
		this.limite = limite;
		
		if(limite < 0)
			this.limite = 1000.0;
	}

	/**
	 * Informa o valor limite de saque.
	 * 
	 * @return O limite de saque.
	 */
	public double getLimite() 
	{
		return limite;
	}

	/**
	 * Retira um valor do saldo da conta.
	 * 
	 * @param value Valor a sacar.
	 * @throws SaldoInsuficienteException Se o valor for maior que o limite de saque, ou o valor for negativo.
	 */
	public void sacar( double value ) throws SaldoInsuficienteException
	{
		if ( value > getLimite() || value < 0 )
			throw new SaldoInsuficienteException();
		
		saldo -= value;
	}
	
	/**
	 * Informa o tipo de conta.
	 * 
	 * @return O tipo desta conta.
	 */
	public String getType() {
		return "Especial";
	}
}
