package com.senac.gerenciador.model;

public class Funcionario {

	private static int proximaMatricula = 1;
	
	private int matricula;
	private Cargo cargo;
	private double salario;
	
	public Funcionario(Cargo cargo, double salario) throws Exception {
		
		if ( salario < cargo.getSalarioMinimo() )
			throw new java.lang.Exception();
		
		this.matricula = proximaMatricula;
		this.cargo = cargo;
		this.salario = salario;
		
		proximaMatricula++;
	}

	public int getMatricula() {
		return matricula;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void ajustaSalario(double ajuste) throws Exception {
		if ( ajuste < 0 || ajuste < cargo.getDissidio() )
			throw new Exception();
		
		this.salario = this.salario * (100 + ajuste) / 100;
	}

}
