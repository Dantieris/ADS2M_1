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
		if ( caminhao.getCargas() > 0 ) {
			caminhao.dimCargas();
			deserto.addUnidade();
		}
		
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}

	public Deserto getDeserto() {
		return deserto;
	}

	public void carregar() {
		if ( deserto.getUnidades()[ deserto.getDistancia() ] > 0 ) {
			caminhao.addCargas();
			deserto.dimUnidade();
		}
	}
	
	public void avancar() {
		if ( caminhao.getCargas() > 0 && deserto.getDistancia() < 10) {
			caminhao.dimCargas();
			deserto.addDistancia();
		}
	}

	public void recuar() {
		if ( caminhao.getCargas() > 0 ) {
			caminhao.dimCargas();
			deserto.dimDistancia();
		}
	}

}
