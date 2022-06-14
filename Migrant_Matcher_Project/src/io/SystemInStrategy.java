package io;

import java.util.Scanner;

import main.InputOutput;

public class SystemInStrategy implements InputOutput {
		
	private Scanner sc;
	
	public SystemInStrategy() {
		this.sc = new Scanner(System.in);
	}

	@Override
	public String pergunta(String pergunta) {
		System.out.println(pergunta);
		System.out.print("\t-> ");
		return sc.next();
	}

	@Override
	public String getNome(String pronome, String deAlguem) {
		System.out.println("Indique o " + pronome + "nome " + deAlguem + ":");
		System.out.print("\n\t-> ");
		return sc.next();
	}

	@Override
	public int getInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void escreve(String s) {
		System.out.println(s);
		
	}

	@Override
	public int getTel(String deAlguem) {
		try {
			System.out.println("Indique o telémovel " + deAlguem + ":");
			System.out.print("\n\t-> ");
			return Integer.parseInt(sc.next());
		}
		catch (NumberFormatException e) {
			System.out.println("Número de telemovel inválido. \nPor favor tente novamente...");
			return getTel(deAlguem);
		}
	}

}
