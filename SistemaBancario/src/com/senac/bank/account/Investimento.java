package com.senac.bank.account;

/**
 * Esta classe representa uma conta banc�ria de investimento, cont�m: 
 * n�mero da conta, n�mero de verifica��o, saldo, 
 * e data para gerar dividendos do investimento.
 *
 */
public class Investimento extends Conta
{
	private int data;
	
	/**
	 * Inicializa um objeto Investimento rec�m-criado com saldo 0, data inicial 0, n�mero de conta e verifica��o gerados automaticamente
	 */
	public Investimento() 
	{
		super();
		this.data = 0;
	}

	/**
	 * Inicializa um objeto Investimento rec�m-criado com data inicial 0, 
	 * saldo definido pelo parametro, e n�mero de conta tamb�m, 
	 * o n�mero de verifica��o � gerado automaticamente.
	 * 
	 * @param numConta N�mero da conta.
	 * @param saldo Saldo inicial da conta.
	 */
	public Investimento(int numConta, double saldo) {
		super(numConta, saldo);
		this.data = 0;
	}

	/**
	 * Retorna a data de cria��o da conta.
	 * 
	 * @return A data de cria��o.
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
