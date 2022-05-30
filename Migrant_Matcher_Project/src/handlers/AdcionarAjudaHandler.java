package handlers;

import java.util.Scanner;

import handlers.criaAjuda.CriaAjuda;
import regiao.CatalogoRegioes;

public class AdcionarAjudaHandler {
	public CriaAjuda cA;
	private CatalogoRegioes cR;
	public AdcionarAjudaHandler() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Indique o tipo de ajuda que deseja fornecer:");
		String input = sc.next();
		try{
			this.cA = new CriaAjuda(Integer.parseInt(input),cR);
		}
		catch(NumberFormatException e) {
			this.cA = new CriaAjuda(input,cR);
		}

		
	}
	
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Qual o tipo de ajuda que pretende oferecer ?");
//	this.tipoDeAjuda=sc.next();
//	
}
