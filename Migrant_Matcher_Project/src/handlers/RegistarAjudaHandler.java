package handlers;

import java.util.List;
import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.ConfirmaSms;
import ajuda.sms.EnviadoresSMS;
import handlers.criaAjuda.CriaAjuda;
import regiao.CatalogoRegioes;
import utilizador.Voluntario;

public class RegistarAjudaHandler {
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Voluntario voluntario;
	private CriaAjuda criaAjuda;
	private Scanner sc ;
	private List<EnviadoresSMS> pluginsSms;
	
	public RegistarAjudaHandler(Voluntario v,CatalogoRegioes catR,CatalogoAjudas catA,
			List<EnviadoresSMS> plugins,Scanner scIn) {
		this.voluntario = v;
		this.catRegioes = catR;	
		this.catAjudas= catA;
		this.pluginsSms = plugins;
		this.sc = scIn;
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
		this.criaAjuda = new CriaAjuda(sc.next(),catRegioes,this.voluntario);
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
		ConfirmaSms confirm = new ConfirmaSms(pluginsSms);
		confirm.sendCod(String.valueOf(voluntario.getTel()));
		System.out.println("Indique o c�digo que lhe foi enviado por sms:");
		confirma(confirm);

	}

	private void confirma(ConfirmaSms confirm) {
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

	public void querConfirmar() {
		System.out.println("Deseja confirmar a sua doa��o?");
		System.out.print("\n\t-> ");
		if(sc.next().toLowerCase().equals("sim")) {
			adicionarAjuda();
		}
		else {
			System.out.println("Pretende criar uma nova doa��o?");
			if(sc.next().toLowerCase().equals("sim")) {

			}
			else {
				System.out.println("Obrigado por ter utilizado o programa MIGRANT MATCHER!");
				System.exit(0);
			}
		}
		
	}
}
