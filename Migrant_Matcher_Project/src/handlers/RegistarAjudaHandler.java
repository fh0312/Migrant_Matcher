package handlers;

import java.util.List;
import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.ConfirmaAjuda;
import ajuda.sms.EnviadoresSMS;
import handlers.criaAjuda.CriaAjuda;
import regiao.CatalogoRegioes;
import utilizador.Voluntario;

public class RegistarAjudaHandler {
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Voluntario voluntario;
	private CriaAjuda criaAjuda;
	Scanner sc = new Scanner(System.in);
	private List<EnviadoresSMS> pluginsSms;
	
	public RegistarAjudaHandler(Voluntario v,CatalogoRegioes catR,CatalogoAjudas catA,List<EnviadoresSMS> plugins) {
		this.voluntario = v;
		this.catRegioes = catR;	
		this.catAjudas= catA;
		this.pluginsSms = plugins;
	}
	
	public void novaAjuda() {
		System.out.println("Indique o tipo de ajuda que deseja fornecer:\n");
		System.out.println("\t Tipos de Ajuda Disponiveis:");
		for(String s : catAjudas.getTiposAjuda()) {
			System.out.println("\t\t"+ s.toUpperCase());
		}
		System.out.print("\n\t-> ");
		
		qualAjuda(sc.next());
		
	}
	
	private void qualAjuda(String input) {
		switch(input.toLowerCase()) {
			case "alojamento" :
				criaAlojamento();
				break;
				
			case "item" :
				criaItem();
				break;
				
			default :
				System.out.println("\n\t\tO tipo de ajuda introduzido n�o est� dispon�vel. \n"
						+ "\t\tPor favor tente novamente...");
				System.out.print("\n\t\t-> ");
				qualAjuda(sc.next());
				break;
		}	
		
	}

	private void criaItem() {
		System.out.println("Indique a descri��o do item a ser oferecido:");
		System.out.print("\n\t-> ");
		this.criaAjuda = new CriaAjuda(sc.next(),catRegioes);
	}

	private void criaAlojamento() {
		System.out.println("Indique o n�mero m�ximo de ocupa��o do alojamento:");
		System.out.print("\n\t-> ");
		try {
			this.criaAjuda = new CriaAjuda(Integer.parseInt(sc.next()),catRegioes);
		}
		catch(NumberFormatException e) {
			System.out.println("N�mero n�o reconhecido. Por favor tente novamente...");
			criaAlojamento();
		}
		
	}

	public void adicionarAjuda() {
		ConfirmaAjuda confirm = new ConfirmaAjuda(pluginsSms);
		confirm.sendCod(String.valueOf(voluntario.getTel()));
		System.out.println("Indique o c�digo que lhe foi enviado por sms:");
		confirma(confirm);

	}

	private void confirma(ConfirmaAjuda confirm) {
		System.out.print("\n\t-> ");
		if(confirm.estahConfirmado(sc.next())) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}
		else {
			System.out.println("C�digo errado! Porfavor tente novamente.");
			confirma(confirm);
		}
		
		
	}
}