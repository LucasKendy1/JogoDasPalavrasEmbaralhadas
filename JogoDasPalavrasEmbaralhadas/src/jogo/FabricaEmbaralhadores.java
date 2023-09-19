package jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores implements Embaralhador {
	private boolean randomInt;
	private BancoDePalavras b;
	private int tamanhoPalavra;
	private int tamanhoPalavraEmbaralhada;
	private String palavraEmbaralhada;
	private int contador;
	private int index;
	private int X;
	private int Y;
	public FabricaEmbaralhadores(BancoDePalavras b) {
		this.b = b;
	}

	public boolean sorteaEmbaralhador() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public String embaralhaPalavra() {
		
		if(sorteaEmbaralhador()) {
			return embaralhador1();
		}
		else {
			return embaralhador2();
		}
		
	}
	
	@Override
	public String embaralhador1() {
		setTamanhoPalavra(b.getPalavra().length());
		setContador(0);
		String palavra = b.getPalavra();
		char[] palavraTarget = palavra.toCharArray();
		char[] palavraEmb = palavra.toCharArray();
		
		
		do {
			setContador(randomize(30));
		}while(getContador()<= 10);
		
		for(int i=0; i<= getContador(); i++) {
			do {
				setX(randomize(getTamanhoPalavra()));
				setY(randomize(getTamanhoPalavra()));
				if(getX()!= getY()) {
					setContador(getContador()-1);
				}
			}while(getContador() !=  0 && getX() !=  getY());
			palavraEmb[getX()] = palavraTarget[getY()];
			palavraEmb[getY()] = palavraTarget[getX()];
		}
		
		
		String shuffled = String.valueOf(palavraEmb);
		setPalavraEmbaralhada(shuffled);
		return shuffled;
	}
	
	
	
	public int randomize(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}
	
	@Override
	public String embaralhador2() {
		
		List<Character> characters = new ArrayList<>();
        for (char c : b.getPalavra().toCharArray()) {
            characters.add(c);
        }

        
        Collections.shuffle(characters);

        
        StringBuilder shuffled = new StringBuilder();
        for (Character c : characters) {
            shuffled.append(c);
        }
        
        setPalavraEmbaralhada(shuffled.toString());
        return shuffled.toString();
		
	}

	public boolean getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(boolean c) {
		this.randomInt = c;
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

	public void setPalavraEmbaralhada(String p) {
		this.palavraEmbaralhada = p;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	
	
}
