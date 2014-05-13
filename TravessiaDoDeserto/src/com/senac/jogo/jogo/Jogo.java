package com.senac.jogo.jogo;

import com.senac.jogo.caminhao.Caminhao;
import com.senac.jogo.deserto.Deserto;

public class Jogo {

	private Caminhao caminhao;
	private Deserto deserto;
	
	public Jogo() {
		caminhao = new Caminhao();
		deserto = new Deserto();
	}
	
	
	public void descarregar() {
		caminhao.dimCargas();
		deserto.addUnidade();
	}


	public Caminhao getCaminhao() {
		return caminhao;
	}


	public Deserto getDeserto() {
		return deserto;
	}

}
