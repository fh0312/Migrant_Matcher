package handlers;

import java.util.Scanner;

import ajuda.CatalogoAjudas;
import ajuda.sms.ConfirmaAjuda;
import handlers.criaAjuda.CriaAjuda;
import regiao.CatalogoRegioes;
import utilizador.Voluntario;

public class RegistarAjudaHandler {
	private CatalogoAjudas catAjudas;
	private CatalogoRegioes catRegioes;
	private Voluntario voluntario;
	private CriaAjuda criaAjuda;
	
	
	public RegistarAjudaHandler(Voluntario v,CatalogoRegioes catR,CatalogoAjudas catA) {
		this.voluntario = v;
		this.catRegioes = catR;	
		this.catAjudas= catA;
	}
	
	public void novaAjuda() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Indique o tipo de ajuda que deseja fornecer:");
		String input = sc.next();
		sc.close();
		try{
			this.criaAjuda = new CriaAjuda(Integer.parseInt(input),catRegioes);
		}
		catch(NumberFormatException e) {
			this.criaAjuda = new CriaAjuda(input,catRegioes);
		}
	}
	
	public void adionarAjuda() {
		ConfirmaAjuda confirm = new ConfirmaAjuda();
		confirm.sendCod();
		if(confirm.estahConfirmado()) {
			this.voluntario.addAjuda(this.criaAjuda.getAjuda());
			this.catAjudas.adicionaAjuda(criaAjuda.getAjuda());
		}

	}
	
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Qual o tipo de ajuda que pretende oferecer ?");
//	this.tipoDeAjuda=sc.next();
//	
}
