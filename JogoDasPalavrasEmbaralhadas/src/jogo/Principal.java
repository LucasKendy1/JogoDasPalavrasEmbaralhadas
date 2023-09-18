package jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		Principal p = new Principal();
		BancoDePalavras b = new BancoDePalavras();
		FabricaEmbaralhadores f = new FabricaEmbaralhadores(b);
		//p.perguntaEntrada();
		//p.escreveSaida();
		b.sorteaPalavra();
		System.out.println("Embaralhador sorteado: "+ f.sorteaEmbaralhador());
		System.out.println("A palavra sorteada foi: "+ b.getPalavra());
		f.embaralhaPalavra();
		System.out.println("tamanho da palavra: "+ f.getTamanhoPalavra());
		System.out.println("A palavra sorteada foi: "+ b.getPalavra().charAt(0));
		
	}
	
	private String entrada;
	
	public void perguntaEntrada() {
		System.out.println("Sua tentativa: ");
		Scanner in = new Scanner(System.in);
		this.entrada = in.nextLine();
	}
	
	public void escreveSaida() {
		System.out.println(entrada);
	}

}
