package jogo;

import java.util.HashMap;
import java.util.Random;

public class FabricaEmbaralhadores implements Embaralhador {
	private int randomInt;
	private BancoDePalavras b;
	private int tamanhoPalavra;
	private int tamanhoPalavraEmbaralhada;
	private String palavraEmbaralhada;
	HashMap<Integer, String> letras = new HashMap<Integer, String>();
	private int contador;
	
	public FabricaEmbaralhadores(BancoDePalavras b) {
		this.b = b;
	}

	public int sorteaEmbaralhador() {
		Random random = new Random();
		setRandomInt(random.nextInt(2));
		return getRandomInt();
	}
	
	public void embaralhaPalavra() {
		
		sorteaEmbaralhador();
		if(getRandomInt()== 0) {
			embaralhador1();
		}
		else {
			embaralhador2();
		}
		
	}
	
	@Override
	public void embaralhador1() {
		//embaralha
		System.out.println("A palavra que vai ser embaralhada: "+ b.getPalavra());
		setTamanhoPalavra(b.getPalavra().length());
		setContador(0);
		while(getTamanhoPalavra()!= getTamanhoPalavraEmbaralhada()) {
			int a = randomize(getTamanhoPalavra());
			letras.put(getContador(), b.getPalavra().charAt(a));
		}
	}
	  
	public int randomize(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}
	
	@Override
	public void embaralhador2() {
		//embaralha usando StringUtils.shuffle()
		System.out.println("A palavra que vai ser embaralhada: "+ b.getPalavra());
		
	}

	public int getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(int randomInt) {
		this.randomInt = randomInt;
	}

	public int getTamanhoPalavra() {
		return tamanhoPalavra;
	}

	public void setTamanhoPalavra(int tamanhoPalavra) {
		this.tamanhoPalavra = tamanhoPalavra;
	}

	public int getTamanhoPalavraEmbaralhada() {
		return tamanhoPalavraEmbaralhada;
	}

	public void setTamanhoPalavraEmbaralhada(int tamanhoPalavraEmbaralhada) {
		this.tamanhoPalavraEmbaralhada = tamanhoPalavraEmbaralhada;
	}

	public String getPalavraEmbaralhada() {
		return palavraEmbaralhada;
	}

	public void setPalavraEmbaralhada(String palavraEmbaralhada) {
		this.palavraEmbaralhada = palavraEmbaralhada;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	
	
}
