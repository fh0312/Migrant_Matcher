package com.projeto2.sistema.io.plugins;

import java.util.Scanner;

import com.projeto2.sistema.io.InputOutput;

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
		try {
			return Integer.parseInt(sc.next());
		}
		catch(NumberFormatException e) {
			escreve("O n�mero introduzido n�o � v�lido.\n"
					+ "Porfavor tente novamente...\n");
			return getInt();
		}
	}
	
	@Override
	public void escreve(String s) {
		System.out.print(s);
	}
	@Override
	public String recebe() {
		return sc.next();
	}

	@Override
	public int getTel(String deAlguem) {
		try {
			System.out.println("\nIndique o n�mero de tel�movel " + deAlguem + ":");
			System.out.print("\n\t-> ");
			return Integer.parseInt(sc.next());
		}
		catch (NumberFormatException e) {
			System.out.println("N�mero de telemovel inv�lido. \nPor favor tente novamente...");
			return getTel(deAlguem);
		}
	}

}
