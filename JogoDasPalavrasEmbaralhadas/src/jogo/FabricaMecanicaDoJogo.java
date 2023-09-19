package jogo;

import java.io.FileNotFoundException;

public class FabricaMecanicaDoJogo implements MecanicaDoJogo {
	private int qtdTentativas;
	private int qtdPontos;
	private boolean continuar;
	Principal p = new Principal();
	BancoDePalavras b = new BancoDePalavras();
	FabricaEmbaralhadores e = new FabricaEmbaralhadores(b);
	
	public void comecarJogo() throws FileNotFoundException {
		setQtdTentativas(5);
		p.escreveSaida(" --------------- Bem-vindos ao jogo das Palavras Embaralhadas! ---------------");
		p.escreveSaida(" Regra do jogo: -Você tem 5 chances para acertar uma palavra embaralhada");
		p.escreveSaida("                -A cada acerto, irá ser contabilizado 1 ponto");
		p.escreveSaida(" -----------------------------------------------------------------------------");
		setContinuar(true);
		while(isContinuar()) {
			p.escreveSaida("Caso queira parar de jogar, digite 'finalizar'");
			b.sorteaPalavra();
			e.embaralhaPalavra();
			p.escreveVariavel(e.getPalavraEmbaralhada());
			do {
				p.perguntaEntrada();
	
				if(acertouPalavra() ) {
					break;
				}
				if(p.getEntrada().equals("finalizar")) {
					setContinuar(false);
					break;
				}
				if(acabouJogo()) {
					setContinuar(false);
					break;
				}
			}while(!acabouJogo() || !acertouPalavra());
		}
		p.escreveSaida("Sua Pontuação final foi de: ");
		p.escreveVariavelInteira(pontuacaoFinal());
		p.escreveSaida("Obrigado por jogar! :)");
	}
	

	@Override
	public boolean acabouJogo() {
		if(getQtdTentativas()== 0) {
			p.escreveSaida("Jogo finalizado!");
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean acertouPalavra() {
		if(b.getPalavra().equals(p.getEntrada())) {
			System.out.println("Acertou! Parabéns. +1 Ponto");
			setQtdPontos(getQtdPontos()+1);
			acabouJogo();
			return true;
		}
		else {
			setQtdTentativas(getQtdTentativas()-1);
			return false;
		}
		
	}

	@Override
	public boolean podeTentarDnv() {
		p.escreveSaida("Quantidade de tentativas restantes: ");
		p.escreveVariavelInteira(getQtdTentativas());
		if(getQtdTentativas() > 0) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public int pontuacaoFinal() {
		return getQtdPontos();
	}

	public int getQtdTentativas() {
		return qtdTentativas;
	}

	public void setQtdTentativas(int qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}


	public int getQtdPontos() {
		return qtdPontos;
	}


	public void setQtdPontos(int qtdPontos) {
		this.qtdPontos = qtdPontos;
	}


	public boolean isContinuar() {
		return continuar;
	}


	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}

	
}
