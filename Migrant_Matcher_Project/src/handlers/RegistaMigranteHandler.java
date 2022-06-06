package handlers;

import java.util.Scanner;

import utilizador.Familiar;
import utilizador.Migrante;

public class RegistaMigranteHandler {
	
	private Migrante cabecaCasal ;
	private String nome;
	private Scanner sc ;
	
	public RegistaMigranteHandler(Scanner sc) throws NumberFormatException {
		this.sc = sc;
		try{
			qualTipo();
		}
		catch(NumberFormatException e) {
			System.out.println(" Número de telemovel inválido! \nPor favor tente novamente...\n");
			qualTipo();
		}
	}

	private void qualTipo() throws NumberFormatException{
		System.out.println(" - Para se inscrever individualmente:\t indique o seu numero de telemovel");
		System.out.println(" - Para inscrever a sua familia:\t indique o numero de pessoas do seu agregado familiar");
		System.out.print("\n\t-> ");
		int num =Integer.parseInt(sc.next());
		
		if(num>100) { // individual
			this.nome= getNomeInput("");
			this.cabecaCasal= new Migrante(this.nome,num);
		}
		else { // familia
			try {
				registaFamilia(num);
			}
			catch (NumberFormatException e) {
				System.out.println("Número de telemovel inválido. \nPor favor tente novamente...");
				registaFamilia(num);
			}
		}
	}

	private void registaFamilia(int num) throws NumberFormatException{		
		this.cabecaCasal = new Migrante(getNomeInput("do cabeça de casal"),
				getTelInput("do cabeça de casal"));
		adicionaFamiliares(num);
	}

	private void adicionaFamiliares(int n) {
		for(int i = 0;i<n-1;i++) {
			this.cabecaCasal.adicionaFamiliar(new Familiar(getNomeInput("de um familiar")));
		}
	}
	
	private int getTelInput(String extra) {
		try {
			System.out.println("Indique o telémovel " + extra + ":");
			System.out.print("\n\t-> ");
			return Integer.parseInt(sc.next());
		}
		catch (NumberFormatException e) {
			System.out.println("Número de telemovel inválido. \nPor favor tente novamente...");
			return getTelInput(extra);
		}
	}
	
	private String getNomeInput(String extra) {
		System.out.println("Indique o nome " + extra + ":");
		System.out.print("\n\t-> ");
		return sc.next();
	}

	public Migrante getMigrante() {
		return this.cabecaCasal;
	}

}
