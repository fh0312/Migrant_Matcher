package handlers;

import java.util.ArrayList;
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
		System.out.println("Indique o tipo de ajuda que deseja fornecer:");
		System.out.print("\n\t-> ");
		String input = sc.next();
		try{
			this.criaAjuda = new CriaAjuda(Integer.parseInt(input),catRegioes);
		}
		catch(NumberFormatException e) {
			this.criaAjuda = new CriaAjuda(input,catRegioes);
		}
	}
	
	public void adicionarAjuda() {
		ConfirmaAjuda confirm = new ConfirmaAjuda(pluginsSms);
		confirm.sendCod(String.valueOf(voluntario.getTel()));
		System.out.println("Indique o código que lhe foi enviado por sms:");
		confirma(confirm);

	}

	private void confirma(ConfirmaAjuda confirm) {
		System.out.print("\n\t-> ");
		if(confirm.estahConfirmado(sc.next())) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}
		else {
			System.out.println("Código errado! Porfavor tente novamente.");
			confirma(confirm);
		}
		
		
	}
	
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Qual o tipo de ajuda que pretende oferecer ?");
//	this.tipoDeAjuda=sc.next();
//	
}
