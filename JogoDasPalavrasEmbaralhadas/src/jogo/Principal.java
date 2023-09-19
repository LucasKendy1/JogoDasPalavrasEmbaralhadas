package jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		FabricaMecanicaDoJogo mec = new FabricaMecanicaDoJogo();
		mec.comecarJogo();
	}
	
	private String entrada;
	
	public void perguntaEntrada() {
		System.out.println("Sua tentativa: ");
		Scanner in = new Scanner(System.in);
		this.setEntrada(in.nextLine());
	}
	
	public void escreveSaida(String s) {
		System.out.println(s+"\r");
	}
	
	public void escreveVariavel(String s) {
		System.out.println(s+"\r");
	}
	public void escreveVariavelInteira(int n) {
		System.out.println(n+"\r");
	}
	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

}
