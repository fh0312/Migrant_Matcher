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
		this.sc = new Scanner(System.in);
		System.out.println(pergunta);
		System.out.print("\t-> ");
		String resposta="";
        resposta += sc.nextLine();
		return resposta;
	}

	@Override
	public String getNome(String pronome, String deAlguem) {
		this.sc = new Scanner(System.in);
		System.out.println("Indique o " + pronome + "nome " + deAlguem + ":");
		System.out.print("\n\t-> ");
		String resposta="";
        resposta += sc.nextLine();
		return resposta;
	}

	@Override
	public int getInt() {
		this.sc = new Scanner(System.in);
		try {
			String resposta="";
	        resposta += sc.next();
			return Integer.parseInt(resposta);
		}
		catch(NumberFormatException e) {
			escreve("O número introduzido não é válido.\n"
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
		String resposta="";
        resposta += sc.nextLine();
		return resposta;
	}

	@Override
	public int getTel(String deAlguem) {
		try {
			System.out.println("\nIndique o número de telémovel " + deAlguem + ":");
			System.out.print("\n\t-> ");
			String resposta="";
	        resposta += sc.next();
			return Integer.parseInt(resposta);
		}
		catch (NumberFormatException e) {
			System.out.println("Número de telemovel inválido. \nPor favor tente novamente...");
			return getTel(deAlguem);
		}
	}

	@Override
	public void sair() {
		this.sc.close();	
	}

}
