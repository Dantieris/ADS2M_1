package com.senac.jogo.jogo;

import com.senac.jogo.caminhao.Caminhao;
import com.senac.jogo.deserto.Deserto;
import com.senac.jogo.view.JogoView;

public class Jogo {

	private Caminhao caminhao;
	private Deserto deserto;
	private JogoView view;
	
	public Jogo() {
		caminhao = new Caminhao();
		deserto  = new Deserto();
		view 	 = new JogoView();
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
		if ( caminhao.getCargas() > 0 && deserto.getDistancia() > 0 ) {
			caminhao.dimCargas();
			deserto.dimDistancia();
		}
	}

	public void run() {
		while(true) {
			view.printLine( "\nDigite o comando:" );
			
			String comando = view.getStringLowCase();
			
			if ( comando.equalsIgnoreCase( "avan�ar" ) ) {
				avancar();
			}
			else
				if ( comando.equalsIgnoreCase( "voltar" ) ) {
					recuar();
				}
				else
					if ( comando.equalsIgnoreCase( "largar" ) ) {
						descarregar();
					}
					else
						if ( comando.equalsIgnoreCase( "carregar" ) ) {
							carregar();
						}
						else
							view.printLine( "Comando inv�lido. Tente novamente.\n" );
		
			if ( deserto.getDistancia() == 10 ) {
				view.printLine( "Parab�ns, Voc� ganhou!" );
				return;
			}
			else
				if ( caminhao.getCargas() <= 0 ) {
					view.printLine( "Voc� perdeu, tente novamente." );
					return;
				}	
			printStatus();
		}
		
	}
	
	private void printStatus() {
		view.printLine( "\nPosi��o do caminh�o: " + getDeserto().getDistancia()
				+ "\nCombust�vel do caminh�o: " + getCaminhao().getCargas());
	}
}
