package jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {
	private String palavra;
	private int randomInt;
	private int index;
	HashMap<Integer, String> palavras = new HashMap<Integer, String>();
	
	public String sorteaPalavra() throws FileNotFoundException {
		leArquivo();
		Random random = new Random();
		setRandomInt(random.nextInt(getIndex()));
		setPalavra(palavras.get(getRandomInt()));
		return getPalavra();
	}
	
	public void leArquivo() throws FileNotFoundException{
		File file = new File("/LUCAS 2023/JAVA/JogoDasPalavrasEmbaralhadas/banco-de-palavras.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			//System.out.println(scan.nextLine());
			palavras.put(getIndex(), scan.nextLine());
			setIndex(getIndex()+1);
		}
		//printHash(palavras);
	}
	
	//Teste de leitura de arquivo .txt
	/*private static void printHash(HashMap<Integer, String> palavra) {
		for(String p:palavra.values()) {
        	System.out.println(p);
        }
	}*/
	
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getRandomInt() {
		return randomInt;
	}

	public void setRandomInt(int randomInt) {
		this.randomInt = randomInt;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	
}
