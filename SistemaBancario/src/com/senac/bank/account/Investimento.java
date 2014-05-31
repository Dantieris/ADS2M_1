package com.senac.bank.account;

/**
 * Esta classe representa uma conta bancária de investimento, contém: 
 * número da conta, número de verificação, saldo, 
 * e data para gerar dividendos do investimento.
 *
 */
public class Investimento extends Conta
{
	private int data;
	
	/**
	 * Inicializa um objeto Investimento recém-criado com saldo 0, data inicial 0, número de conta e verificação gerados automaticamente
	 */
	public Investimento() 
	{
		super();
		this.data = 0;
	}

	/**
	 * Inicializa um objeto Investimento recém-criado com data inicial 0, 
	 * saldo definido pelo parametro, e número de conta também, 
	 * o número de verificação é gerado automaticamente.
	 * 
	 * @param numConta Número da conta.
	 * @param saldo Saldo inicial da conta.
	 */
	public Investimento(int numConta, double saldo) {
		super(numConta, saldo);
		this.data = 0;
	}

	/**
	 * Retorna a data de criação da conta.
	 * 
	 * @return A data de criação.
	 */
	public int getDataCriacao() 
	{
		return this.data;
	}
	
	/**
	 * Aumenta o saldo da conta de acordo com uma taxa enviada por parametro.
	 * 
	 * @param taxa A porcentagem de aumento.
	 */
	public void dividendos( double taxa )
	{
		double value = ( (getBalance() / 100 ) * taxa );
		depositar(value);
	}
	
	/**
	 * Informa o tipo de conta.
	 * 
	 * @return O tipo desta conta.
	 */
	public String getType() {
		return "Investimento";
	}
	
}
